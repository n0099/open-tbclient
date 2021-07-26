package d.a.q0.c2.h.d;

import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.managers.SingleThreadEmotionHorizontalAdater;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.c2.h.f.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SingleThreadEmotionHorizontalAdater f55347a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f55348b;

    /* renamed from: c  reason: collision with root package name */
    public e f55349c;

    /* renamed from: d  reason: collision with root package name */
    public List<EmotionPackageData> f55350d;

    public b(TbPageContext<?> tbPageContext, BdListView bdListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55348b = bdListView;
        e eVar = new e(tbPageContext);
        this.f55349c = eVar;
        eVar.c(TbadkCoreApplication.getInst().getSkinType());
        this.f55348b.addHeaderView(this.f55349c.b());
        this.f55350d = new ArrayList();
        SingleThreadEmotionHorizontalAdater singleThreadEmotionHorizontalAdater = new SingleThreadEmotionHorizontalAdater(this.f55350d, tbPageContext);
        this.f55347a = singleThreadEmotionHorizontalAdater;
        this.f55348b.setAdapter((ListAdapter) singleThreadEmotionHorizontalAdater);
    }

    public void a(List<EmotionPackageData> list) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null || (eVar = this.f55349c) == null || this.f55347a == null) {
            return;
        }
        eVar.d(Integer.valueOf(list.size()));
        this.f55350d.clear();
        if (list != null) {
            this.f55350d.addAll(list);
        }
        this.f55347a.notifyDataSetChanged();
    }
}
