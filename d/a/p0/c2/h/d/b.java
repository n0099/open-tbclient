package d.a.p0.c2.h.d;

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
import d.a.p0.c2.h.f.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SingleThreadEmotionHorizontalAdater f54803a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f54804b;

    /* renamed from: c  reason: collision with root package name */
    public e f54805c;

    /* renamed from: d  reason: collision with root package name */
    public List<EmotionPackageData> f54806d;

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
        this.f54804b = bdListView;
        e eVar = new e(tbPageContext);
        this.f54805c = eVar;
        eVar.c(TbadkCoreApplication.getInst().getSkinType());
        this.f54804b.addHeaderView(this.f54805c.b());
        this.f54806d = new ArrayList();
        SingleThreadEmotionHorizontalAdater singleThreadEmotionHorizontalAdater = new SingleThreadEmotionHorizontalAdater(this.f54806d, tbPageContext);
        this.f54803a = singleThreadEmotionHorizontalAdater;
        this.f54804b.setAdapter((ListAdapter) singleThreadEmotionHorizontalAdater);
    }

    public void a(List<EmotionPackageData> list) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null || (eVar = this.f54805c) == null || this.f54803a == null) {
            return;
        }
        eVar.d(Integer.valueOf(list.size()));
        this.f54806d.clear();
        if (list != null) {
            this.f54806d.addAll(list);
        }
        this.f54803a.notifyDataSetChanged();
    }
}
