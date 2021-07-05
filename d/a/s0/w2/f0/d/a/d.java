package d.a.s0.w2.f0.d.a;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.n1.o.l.j;
import d.a.s0.w2.i0.e;
import d.a.s0.w2.i0.g;
import d.a.s0.w2.k;
import d.a.s0.w2.x;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class d implements k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public j f69185a;

    /* renamed from: b  reason: collision with root package name */
    public AdvertAppInfo f69186b;

    /* loaded from: classes9.dex */
    public class a implements d.a.s0.n1.o.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo.ILegoAdvert f69187a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f69188b;

        public a(d dVar, AdvertAppInfo.ILegoAdvert iLegoAdvert) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, iLegoAdvert};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69188b = dVar;
            this.f69187a = iLegoAdvert;
        }

        @Override // d.a.s0.n1.o.a
        public void a(int i2, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, hashMap) == null) || i2 == 0 || this.f69188b.f69186b == null) {
                return;
            }
            String str = "image";
            if (hashMap != null) {
                String str2 = (String) hashMap.get("da_area");
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
            }
            if (x.p(i2)) {
                d.a.s0.w2.i0.d.e(this.f69188b.f69186b, 0, str, i2);
            } else {
                d.a.s0.w2.i0.d.m(this.f69188b.f69186b, 0, null, null, str);
            }
            d.a.s0.n1.o.h.c.h(d.a.s0.n1.o.h.c.e(this.f69187a.getAdvertAppInfo()));
        }
    }

    public d(@NonNull TbPageContext<?> tbPageContext, @NonNull AdvertAppInfo.ILegoAdvert iLegoAdvert, int i2, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, iLegoAdvert, Integer.valueOf(i2), Boolean.valueOf(z), str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69186b = iLegoAdvert.getAdvertAppInfo();
        b bVar = new b(tbPageContext);
        bVar.setBusinessType(i2);
        bVar.setFromCDN(z);
        bVar.i(iLegoAdvert);
        bVar.setAfterClickSchemeListener(new a(this, iLegoAdvert));
        this.f69185a = bVar;
    }

    @Override // d.a.s0.w2.k
    public void a(DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) {
            this.f69185a.a(hVar);
        }
    }

    @Override // d.a.s0.w2.k
    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f69185a.b() : (View) invokeV.objValue;
    }

    @Override // d.a.s0.w2.k
    public void onAdShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AdvertAppInfo advertAppInfo = this.f69186b;
            if (advertAppInfo.Q3) {
                d.a.s0.q.e.a.i().k(d.a.s0.q.e.a.g(this.f69186b));
                e.b().d(g.b(this.f69186b, 103, 0));
                return;
            }
            d.a.s0.n1.o.h.c.g(d.a.s0.n1.o.h.c.e(advertAppInfo));
            e.b().d(g.b(this.f69186b, 3, 0));
        }
    }

    @Override // d.a.s0.w2.k
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f69185a.onDestroy();
        }
    }
}
