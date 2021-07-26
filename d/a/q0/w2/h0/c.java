package d.a.q0.w2.h0;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.w2.f0.d.a.d;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class c implements d.a.q0.w2.b0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.a.q0.q.b.a f66665a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, AdvertAppInfo> f66666b;

    /* renamed from: c  reason: collision with root package name */
    public d f66667c;

    /* renamed from: d  reason: collision with root package name */
    public int f66668d;

    public c(IAdBaseAsyncController.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        d.a.q0.q.b.a aVar2 = new d.a.q0.q.b.a(PlaceId.PIC_PAGE_INSERT, "PIC_PAGE", aVar);
        this.f66665a = aVar2;
        aVar2.f(false);
        this.f66666b = new HashMap();
        this.f66668d = d.a.q0.a.h().j();
    }

    @Override // d.a.q0.w2.b0.b
    public void b(@NonNull String str, @NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, advertAppInfo) == null) {
            this.f66666b.put(str, advertAppInfo);
        }
    }

    @Override // d.a.q0.w2.b0.b
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = 0;
            if (this.f66666b.isEmpty()) {
                return 0;
            }
            for (AdvertAppInfo advertAppInfo : this.f66666b.values()) {
                if (!d.a.q0.w2.a.n(advertAppInfo)) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // d.a.q0.w2.b0.b
    public boolean d(@NonNull String str) {
        InterceptResult invokeL;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? (TextUtils.isEmpty(str) || (advertAppInfo = this.f66666b.get(str)) == null || d.a.q0.w2.a.n(advertAppInfo)) ? false : true : invokeL.booleanValue;
    }

    @Override // d.a.q0.w2.b0.b
    public void e(@NonNull d.a.p0.b1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("forum_id", cVar.l);
            hashMap.put("forum_name", cVar.m);
            this.f66665a.d(this.f66668d, hashMap);
        }
    }

    @Override // d.a.q0.w2.b0.b
    public View f(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.f66667c.b(this.f66666b.get(str)) : (View) invokeL.objValue;
    }

    @Override // d.a.q0.w2.b0.b
    public void h(@NonNull TbPageContext tbPageContext, @NonNull DragImageView.h hVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048581, this, tbPageContext, hVar, z) == null) {
            this.f66667c = new d(tbPageContext, z, hVar);
        }
    }

    @Override // d.a.q0.w2.b0.b
    public void i(@NonNull String str) {
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (advertAppInfo = this.f66666b.get(str)) == null) {
            return;
        }
        d.a.q0.w2.i0.d.p(advertAppInfo);
    }

    @Override // d.a.q0.w2.b0.b
    public void j(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, advertAppInfo) == null) {
            d.a.q0.w2.i0.d.h(advertAppInfo, 0, 2);
        }
    }

    @Override // d.a.q0.w2.b0.b
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? !this.f66666b.isEmpty() : invokeV.booleanValue;
    }

    @Override // d.a.q0.w2.b0.b
    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f66667c.d(this.f66666b.get(str));
        }
    }

    @Override // d.a.q0.w2.b0.b
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f66667c.c();
            this.f66665a.b();
        }
    }
}
