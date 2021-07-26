package d.a.p0.s.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class w implements Comparable<w> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f53457e;

    /* renamed from: f  reason: collision with root package name */
    public int f53458f;

    /* renamed from: g  reason: collision with root package name */
    public String f53459g;

    /* renamed from: h  reason: collision with root package name */
    public String f53460h;

    /* renamed from: i  reason: collision with root package name */
    public String f53461i;
    public String j;
    public String k;
    public String l;
    public boolean m;
    public String n;
    public String o;
    public String p;
    public String q;
    public boolean r;
    public int s;
    public int t;

    public w(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53457e = i2;
        this.f53458f = i3;
    }

    public static w b(TbLinkSpanGroup tbLinkSpanGroup, d.a.q0.a1.a aVar) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, aVar)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            w wVar = new w(tbLinkSpanGroup.e(), 2);
            if (aVar == null) {
                return wVar;
            }
            if (TextUtils.isEmpty(aVar.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
            } else {
                str = aVar.f() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
            }
            wVar.f53460h = str;
            wVar.f53459g = aVar.c();
            wVar.q = aVar.a();
            if (!ListUtils.isEmpty(aVar.b()) && aVar.b().get(0) != null) {
                wVar.f53461i = aVar.b().get(0).a();
            }
            wVar.p = aVar.f();
            wVar.j = aVar.d();
            if (aVar.e() != null) {
                wVar.n = aVar.e().a();
                wVar.o = aVar.e().b();
            }
            tbLinkSpanGroup.y(wVar);
            return wVar;
        }
        return (w) invokeLL.objValue;
    }

    public static w c(TbLinkSpanGroup tbLinkSpanGroup, d.a.p0.s.f0.s.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, dVar)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            w wVar = new w(tbLinkSpanGroup.e(), 1);
            if (dVar == null) {
                return wVar;
            }
            wVar.f53459g = dVar.f53072e;
            wVar.f53461i = dVar.f53071d;
            wVar.p = dVar.f53073f;
            wVar.j = dVar.f53074g;
            wVar.k = dVar.f53070c;
            wVar.r = dVar.f53075h;
            String str = dVar.f53076i;
            wVar.m = dVar.f53069b == 1;
            wVar.s = dVar.f53069b;
            tbLinkSpanGroup.y(wVar);
            return wVar;
        }
        return (w) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull w wVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wVar)) == null) ? this.t - wVar.t : invokeL.intValue;
    }
}
