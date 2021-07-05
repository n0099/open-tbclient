package d.a.s0.c2.h.d;

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
import d.a.s0.c2.h.f.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdListView f58049a;

    /* renamed from: b  reason: collision with root package name */
    public MyEmotionHorizontalAdater f58050b;

    /* renamed from: c  reason: collision with root package name */
    public List<EmotionPackageData> f58051c;

    /* renamed from: d  reason: collision with root package name */
    public final List<C1356a> f58052d;

    /* renamed from: e  reason: collision with root package name */
    public c f58053e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.c2.h.b.a f58054f;

    /* renamed from: d.a.s0.c2.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1356a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f58055a;

        /* renamed from: b  reason: collision with root package name */
        public int f58056b;

        /* renamed from: c  reason: collision with root package name */
        public int f58057c;

        public C1356a() {
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
                return "id: " + this.f58055a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "firstVisibleItem: " + this.f58056b + StringUtil.ARRAY_ELEMENT_SEPARATOR + "padX: " + this.f58057c;
            }
            return (String) invokeV.objValue;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, d.a.s0.c2.h.b.a aVar) {
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
        this.f58049a = bdListView;
        c cVar = new c(tbPageContext);
        this.f58053e = cVar;
        cVar.b(TbadkCoreApplication.getInst().getSkinType());
        this.f58049a.addHeaderView(this.f58053e.a());
        this.f58051c = new ArrayList();
        this.f58052d = new ArrayList();
        MyEmotionHorizontalAdater myEmotionHorizontalAdater = new MyEmotionHorizontalAdater(this.f58051c, this.f58052d, tbPageContext);
        this.f58050b = myEmotionHorizontalAdater;
        this.f58054f = aVar;
        this.f58049a.setAdapter((ListAdapter) myEmotionHorizontalAdater);
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || i2 < 0 || i2 >= this.f58051c.size() || i3 < 0 || i3 >= this.f58051c.size()) {
            return;
        }
        List<EmotionPackageData> list = this.f58051c;
        list.add(i3, list.remove(i2));
        List<C1356a> list2 = this.f58052d;
        list2.add(i3, list2.remove(i2));
        this.f58050b.notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921312, new Pair(Integer.valueOf(i2), Integer.valueOf(i3))));
    }

    public void b() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f58050b == null || this.f58049a == null || this.f58051c == null || (cVar = this.f58053e) == null || this.f58054f == null) {
            return;
        }
        cVar.c();
        this.f58054f.b(0, this.f58050b.b());
        this.f58054f.a(d.a.s0.c2.h.a.b().a());
        this.f58050b.notifyDataSetChanged();
    }

    public void c(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || this.f58049a == null || this.f58050b == null) {
            return;
        }
        this.f58051c.clear();
        this.f58051c.addAll(list);
        d();
        this.f58050b.d();
        this.f58053e.d(Integer.valueOf(this.f58050b.b()));
        this.f58054f.b(0, this.f58050b.b());
        this.f58054f.a(d.a.s0.c2.h.a.b().a());
        this.f58050b.notifyDataSetChanged();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ArrayList arrayList = new ArrayList(this.f58052d);
            this.f58052d.clear();
            for (EmotionPackageData emotionPackageData : this.f58051c) {
                C1356a c1356a = null;
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C1356a c1356a2 = (C1356a) it.next();
                    if (c1356a2 != null && c1356a2.f58055a == emotionPackageData.id) {
                        c1356a = c1356a2;
                        break;
                    }
                }
                if (c1356a == null) {
                    c1356a = new C1356a();
                    c1356a.f58055a = emotionPackageData.id;
                }
                this.f58052d.add(c1356a);
            }
        }
    }
}
