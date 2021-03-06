package hu.unideb.inf.kondibazis.db.entitas;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

/**
 * Az adatbázisban egy konditeremet reprezentáló osztály.
 * Ez egy entitás amit az adatbázisba leképezve egy konditerem nevű táblát kapunk a megfelelő oszlopokkal.
 */
@Entity
@Table(name = "konditerem")
public class Konditerem extends FoEntitas {

    /**
     * Alapértelmezett szerializációs azonosító.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Üres konstruktor a szerializálhatóság miatt.
     */
    public Konditerem() {
    }

    /**
     * A konditerem felhasználóneve, amely legalább kötelezően 5 karakterből áll.
     * Ez egy egyedi felhasználónév, csak egyszer szerepelhet.
     * Ezt a {@link javax.persistence.Column Column} annotáció unique=true tagja biztosítja.
     */
    @Column(name = "felhasznalonev", unique = true)
    @Size(min = 5)
    private String felhasznalonev;

    /**
     * A konditerem jelszava, amely legalább kötelezően 8 karakterből áll..
     */
    @Column(name = "jelszo", unique = true)
    @Size(min = 8)
    private String jelszo;

    /**
     * A konditerem neve.
     */
    @Column(name = "konditeremNeve", unique = true)
    private String konditeremNeve;

    /**
     * A konditerem regisztrálásának a dátuma.
     */
    @Column(name = "regisztralasDatuma")
    private LocalDate regisztralasDatuma;

    /**
     * A konditrem tagjainak a száma.
     */
    @Column(name = "tagokSzama")
    private Integer tagokSzama;

    /**
     * A konditeremhez tartozó tagok. Minden tagot külön kezelünk így minden konditerem rendelkezik egy listával, amelyben a tagjai szerepelnek.
     * A {@link javax.persistence.OneToMany OnToMany} annotáció megmondja hogy egy konditeremhez több tag tartozik.
     * A mappedBy taggal megadjuk hogy hol találja a Hibernate a konfigurációt ehhez az adattaghoz, ezesetben a kapcsolat másik
     * oldalán a "konditerem" nevű adattagon lesz megadva a konfiguráció. A fetch=FetchType.LAZY konfigurációval megmondjuk hogy az adatbázisból a konditeremhez
     * a tagokat csak akkor kérdezze le, ha ténylegesen használja a kód.
     */
    @OneToMany(mappedBy = "konditerem", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<KonditeremTag> konditeremTagok;

    /**
     * A konditeremhez tartozó bérletek. Minden bérletet külön kezelünk így minden konditerem rendelkezik egy listával, amelyben a bérletei szerepelnek.
     * A {@link javax.persistence.OneToMany OnToMany} annotáció megmondja hogy egy konditeremhez több bérlet tartozik.
     * A mappedBy taggal megadjuk hogy hol találja a Hibernate a konfigurációt ehhez az adattaghoz, ezesetben a kapcsolat másik
     * oldalán a "konditerem" nevű adattagon lesz megadva a konfiguráció. A fetch=FetchType.LAZY konfigurációval megmondjuk hogy az adatbázisból a konditeremhez
     * a bérleteket csak akkor kérdezze le, ha ténylegesen használja a kód.
     */
    @OneToMany(mappedBy = "konditerem", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<KonditeremBerlet> konditeremBerletek;

    /**
     * A konditeremhez tartozó elérhetőségek. Minden elérhetőséget külön kezelünk így minden konditerem rendelkezik egy listával, amelyben az elérhetőségek szerepelnek.
     * A {@link javax.persistence.OneToMany OnToMany} annotáció megmondja hogy egy konditeremhez több elérhetőség tartozik.
     * A mappedBy taggal megadjuk hogy hol találja a Hibernate a konfigurációt ehhez az adattaghoz, ezesetben a kapcsolat másik
     * oldalán a "konditerem" nevű adattagon lesz megadva a konfiguráció. A fetch=FetchType.LAZY konfigurációval megmondjuk hogy az adatbázisból a konditeremhez
     * az elérhetőséget csak akkor kérdezze le, ha ténylegesen használja a kód.
     */
    @OneToMany(mappedBy = "konditerem", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<KonditeremElerhetoseg> konditeremElerhetosegek;

    /**
     * Visszaadja a konditerem felhasználónevét.
     *
     * @return A konditerem felhasználóneve.
     */
    public String getFelhasznalonev() {
        return felhasznalonev;
    }

    /**
     * Beállítja a konditerem felhasználónevét.
     *
     * @param felhasznalonev A beállítandó felhasználónév.
     */
    public void setFelhasznalonev(String felhasznalonev) {
        this.felhasznalonev = felhasznalonev;
    }

    /**
     * Visszaadja a konditerem jelszavát.
     *
     * @return A konditerem jelszava.
     */
    public String getJelszo() {
        return jelszo;
    }

    /**
     * Beállítja a konditerem jelszavát.
     *
     * @param jelszo A beállítandó jelszó.
     */
    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    /**
     * Visszaadja a konditerem nevét.
     *
     * @return A konditerem neve.
     */
    public String getKonditeremNeve() {
        return konditeremNeve;
    }

    /**
     * Beállítja a konditerem nevét.
     *
     * @param konditeremNeve A beállítandó név.
     */
    public void setKonditeremNeve(String konditeremNeve) {
        this.konditeremNeve = konditeremNeve;
    }

    /**
     * Visszaadja a konditerem tagjainak a számát.
     *
     * @return A konditerem tagjainak a száma.
     */
    public Integer getTagokSzama() {
        return tagokSzama;
    }

    /**
     * Beállítja a konditerem tagjainak a számát.
     *
     * @param tagokSzama A beállítandó szám.
     */
    public void setTagokSzama(Integer tagokSzama) {
        this.tagokSzama = tagokSzama;
    }

    /**
     * Visszaadja a konditerem tagjait.
     *
     * @return Egy {@link java.util.List List} amiben a kondietrem tagjai szerepelnek.
     */
    public List<KonditeremTag> getKonditeremTagok() {
        return konditeremTagok;
    }

    /**
     * Beállítja a konditerem tagjait.
     *
     * @param konditeremTagok A {@link java.util.List List} amiben a konditerem tagjai vannak.
     */
    public void setKonditeremTagok(List<KonditeremTag> konditeremTagok) {
        this.konditeremTagok = konditeremTagok;
    }

    /**
     * Visszaadja a konditerem regisztrálásának a dátumát.
     *
     * @return A konditerem regisztrálásának a dátuma.
     */
    public LocalDate getRegisztralasDatuma() {
        return regisztralasDatuma;
    }

    /**
     * Beállítja a konditerem regisztrálásának a dátumát.
     *
     * @param regisztralasDatuma A beállítandó dátum.
     */
    public void setRegisztralasDatuma(LocalDate regisztralasDatuma) {
        this.regisztralasDatuma = regisztralasDatuma;
    }

    /**
     * Visszaadja a konditerem bérleteit.
     *
     * @return Egy {@link java.util.List List} amiben a konditerem bérletei szerepelnek.
     */
    public List<KonditeremBerlet> getKonditeremBerletek() {
        return konditeremBerletek;
    }

    /**
     * Beállítja a konditerem bérleteit.
     *
     * @param konditeremBerletek A {@link java.util.List List} amiben a konditerem bérletei vannak.
     */
    public void setKonditeremBerletek(List<KonditeremBerlet> konditeremBerletek) {
        this.konditeremBerletek = konditeremBerletek;
    }

    /**
     * Visszaadja a konditerem elérhetőségeit.
     *
     * @return Egy {@link java.util.List List} amiben a konditerem elérhetőségei szerepelnek.
     */
    public List<KonditeremElerhetoseg> getKonditeremElerhetosegek() {
        return konditeremElerhetosegek;
    }

    /**
     * Beállítja a konditerem elérhetőségeit.
     *
     * @param konditeremElerhetosegek A {@link java.util.List List} amiben a konditerem elérhetőségei vannak.
     */
    public void setKonditeremElerhetosegek(List<KonditeremElerhetoseg> konditeremElerhetosegek) {
        this.konditeremElerhetosegek = konditeremElerhetosegek;
    }
}
