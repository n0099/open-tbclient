package d.a.p0.c2.h.d;

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
import d.a.p0.c2.h.f.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdListView f54794a;

    /* renamed from: b  reason: collision with root package name */
    public MyEmotionHorizontalAdater f54795b;

    /* renamed from: c  reason: collision with root package name */
    public List<EmotionPackageData> f54796c;

    /* renamed from: d  reason: collision with root package name */
    public final List<C1310a> f54797d;

    /* renamed from: e  reason: collision with root package name */
    public c f54798e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.p0.c2.h.b.a f54799f;

    /* renamed from: d.a.p0.c2.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1310a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f54800a;

        /* renamed from: b  reason: collision with root package name */
        public int f54801b;

        /* renamed from: c  reason: collision with root package name */
        public int f54802c;

        public C1310a() {
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
                return "id: " + this.f54800a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "firstVisibleItem: " + this.f54801b + StringUtil.ARRAY_ELEMENT_SEPARATOR + "padX: " + this.f54802c;
            }
            return (String) invokeV.objValue;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, d.a.p0.c2.h.b.a aVar) {
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
        this.f54794a = bdListView;
        c cVar = new c(tbPageContext);
        this.f54798e = cVar;
        cVar.b(TbadkCoreApplication.getInst().getSkinType());
        this.f54794a.addHeaderView(this.f54798e.a());
        this.f54796c = new ArrayList();
        this.f54797d = new ArrayList();
        MyEmotionHorizontalAdater myEmotionHorizontalAdater = new MyEmotionHorizontalAdater(this.f54796c, this.f54797d, tbPageContext);
        this.f54795b = myEmotionHorizontalAdater;
        this.f54799f = aVar;
        this.f54794a.setAdapter((ListAdapter) myEmotionHorizontalAdater);
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || i2 < 0 || i2 >= this.f54796c.size() || i3 < 0 || i3 >= this.f54796c.size()) {
            return;
        }
        List<EmotionPackageData> list = this.f54796c;
        list.add(i3, list.remove(i2));
        List<C1310a> list2 = this.f54797d;
        list2.add(i3, list2.remove(i2));
        this.f54795b.notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921312, new Pair(Integer.valueOf(i2), Integer.valueOf(i3))));
    }

    public void b() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f54795b == null || this.f54794a == null || this.f54796c == null || (cVar = this.f54798e) == null || this.f54799f == null) {
            return;
        }
        cVar.c();
        this.f54799f.b(0, this.f54795b.b());
        this.f54799f.a(d.a.p0.c2.h.a.b().a());
        this.f54795b.notifyDataSetChanged();
    }

    public void c(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || this.f54794a == null || this.f54795b == null) {
            return;
        }
        this.f54796c.clear();
        this.f54796c.addAll(list);
        d();
        this.f54795b.d();
        this.f54798e.d(Integer.valueOf(this.f54795b.b()));
        this.f54799f.b(0, this.f54795b.b());
        this.f54799f.a(d.a.p0.c2.h.a.b().a());
        this.f54795b.notifyDataSetChanged();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ArrayList arrayList = new ArrayList(this.f54797d);
            this.f54797d.clear();
            for (EmotionPackageData emotionPackageData : this.f54796c) {
                C1310a c1310a = null;
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C1310a c1310a2 = (C1310a) it.next();
                    if (c1310a2 != null && c1310a2.f54800a == emotionPackageData.id) {
                        c1310a = c1310a2;
                        break;
                    }
                }
                if (c1310a == null) {
                    c1310a = new C1310a();
                    c1310a.f54800a = emotionPackageData.id;
                }
                this.f54797d.add(c1310a);
            }
        }
    }
}
