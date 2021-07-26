package d.a.q0.c2.h.d;

import android.util.Pair;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.managers.MyEmotionHorizontalAdater;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.c2.h.f.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdListView f55338a;

    /* renamed from: b  reason: collision with root package name */
    public MyEmotionHorizontalAdater f55339b;

    /* renamed from: c  reason: collision with root package name */
    public List<EmotionPackageData> f55340c;

    /* renamed from: d  reason: collision with root package name */
    public final List<C1319a> f55341d;

    /* renamed from: e  reason: collision with root package name */
    public c f55342e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.c2.h.b.a f55343f;

    /* renamed from: d.a.q0.c2.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1319a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f55344a;

        /* renamed from: b  reason: collision with root package name */
        public int f55345b;

        /* renamed from: c  reason: collision with root package name */
        public int f55346c;

        public C1319a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "id: " + this.f55344a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "firstVisibleItem: " + this.f55345b + StringUtil.ARRAY_ELEMENT_SEPARATOR + "padX: " + this.f55346c;
            }
            return (String) invokeV.objValue;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, d.a.q0.c2.h.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdListView, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55338a = bdListView;
        c cVar = new c(tbPageContext);
        this.f55342e = cVar;
        cVar.b(TbadkCoreApplication.getInst().getSkinType());
        this.f55338a.addHeaderView(this.f55342e.a());
        this.f55340c = new ArrayList();
        this.f55341d = new ArrayList();
        MyEmotionHorizontalAdater myEmotionHorizontalAdater = new MyEmotionHorizontalAdater(this.f55340c, this.f55341d, tbPageContext);
        this.f55339b = myEmotionHorizontalAdater;
        this.f55343f = aVar;
        this.f55338a.setAdapter((ListAdapter) myEmotionHorizontalAdater);
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || i2 < 0 || i2 >= this.f55340c.size() || i3 < 0 || i3 >= this.f55340c.size()) {
            return;
        }
        List<EmotionPackageData> list = this.f55340c;
        list.add(i3, list.remove(i2));
        List<C1319a> list2 = this.f55341d;
        list2.add(i3, list2.remove(i2));
        this.f55339b.notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921312, new Pair(Integer.valueOf(i2), Integer.valueOf(i3))));
    }

    public void b() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f55339b == null || this.f55338a == null || this.f55340c == null || (cVar = this.f55342e) == null || this.f55343f == null) {
            return;
        }
        cVar.c();
        this.f55343f.b(0, this.f55339b.b());
        this.f55343f.a(d.a.q0.c2.h.a.b().a());
        this.f55339b.notifyDataSetChanged();
    }

    public void c(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || this.f55338a == null || this.f55339b == null) {
            return;
        }
        this.f55340c.clear();
        this.f55340c.addAll(list);
        d();
        this.f55339b.d();
        this.f55342e.d(Integer.valueOf(this.f55339b.b()));
        this.f55343f.b(0, this.f55339b.b());
        this.f55343f.a(d.a.q0.c2.h.a.b().a());
        this.f55339b.notifyDataSetChanged();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ArrayList arrayList = new ArrayList(this.f55341d);
            this.f55341d.clear();
            for (EmotionPackageData emotionPackageData : this.f55340c) {
                C1319a c1319a = null;
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C1319a c1319a2 = (C1319a) it.next();
                    if (c1319a2 != null && c1319a2.f55344a == emotionPackageData.id) {
                        c1319a = c1319a2;
                        break;
                    }
                }
                if (c1319a == null) {
                    c1319a = new C1319a();
                    c1319a.f55344a = emotionPackageData.id;
                }
                this.f55341d.add(c1319a);
            }
        }
    }
}
