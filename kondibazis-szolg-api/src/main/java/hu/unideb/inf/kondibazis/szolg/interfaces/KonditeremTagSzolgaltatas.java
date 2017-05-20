package hu.unideb.inf.kondibazis.szolg.interfaces;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremBerletVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;

import java.util.List;

public interface KonditeremTagSzolgaltatas {
	
	KonditeremTagVo keresTagot(Long id);

	KonditeremTagVo leterehozTagot(KonditeremTagVo ujTag);

	KonditeremTagVo frissitKonditeremTagot(KonditeremTagVo konditeremTag);

	List<KonditeremTagVo> konditeremOsszesTagja(KonditeremVo konditerem);

	KonditeremBerletVo tagBerlete(KonditeremTagVo konditeremTag);
	
}
