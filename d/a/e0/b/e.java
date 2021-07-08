package d.a.e0.b;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.service.network.Als;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.e0.b.g.h;
import d.a.e0.b.g.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e implements d.a.h0.a.g.a, d.a.h0.a.g.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final d.a.h0.a.g.b f42248e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f42249f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final h f42250g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final d.a.e0.b.g.b f42251h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public d f42252i;
    public long j;
    public long k;
    public final long l;
    public long m;
    public boolean n;
    public d.a.e0.b.g.d o;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f42253e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42253e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f42253e.f42252i.b();
            }
        }
    }

    public e(@NonNull d.a.h0.a.g.b bVar, @NonNull ViewGroup viewGroup, @NonNull h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, viewGroup, hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = true;
        this.l = System.currentTimeMillis();
        this.f42248e = bVar;
        this.f42249f = viewGroup;
        this.f42250g = hVar;
        this.f42251h = new d.a.e0.b.g.b(hVar);
        d.a.e0.b.g.c.b(hVar);
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.n) {
            this.n = false;
            this.f42251h.d(str, this.m);
        }
    }

    public void c(d.a.e0.b.g.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            this.o = dVar;
            d.a.h0.a.g.b bVar = this.f42248e;
            if (bVar != null) {
                dVar.i(bVar);
            }
        }
    }

    public void d(@NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f42252i = dVar;
        }
    }

    @Override // d.a.h0.a.g.a
    public void onAdClick() {
        Als.Area area;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (d.a.e0.a.b.a.f42209a.get() != null) {
                d.a.e0.c.d.a(d.a.e0.a.b.a.f42209a.get().o(), this.f42250g.o);
            }
            b(Als.CloseType.CLICK_AD_AREA.value);
            if (TextUtils.isEmpty(this.f42250g.e())) {
                this.f42251h.a(Als.Area.UNKNOW, "");
                return;
            }
            String e2 = this.f42250g.e();
            char c2 = 65535;
            int hashCode = e2.hashCode();
            if (hashCode != 102340) {
                if (hashCode != 100313435) {
                    if (hashCode == 112202875 && e2.equals("video")) {
                        c2 = 1;
                    }
                } else if (e2.equals("image")) {
                    c2 = 0;
                }
            } else if (e2.equals("gif")) {
                c2 = 2;
            }
            if (c2 == 0) {
                area = Als.Area.IMAGE;
            } else if (c2 == 1) {
                area = Als.Area.VIDEO;
            } else if (c2 != 2) {
                area = Als.Area.UNKNOW;
            } else {
                area = Als.Area.GIF;
            }
            this.f42251h.a(area, "");
            d dVar = this.f42252i;
            if (dVar != null) {
                dVar.onAdClick();
            }
        }
    }

    @Override // d.a.h0.a.g.c
    public void onAdError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.m = System.currentTimeMillis() - this.j;
            d dVar = this.f42252i;
            if (dVar != null) {
                dVar.a(str);
            }
        }
    }

    @Override // d.a.h0.a.g.c
    public void onAdLoad() {
        d.a.e0.b.g.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.k = System.currentTimeMillis();
            if (this.f42252i == null || (dVar = this.o) == null) {
                return;
            }
            dVar.h(!this.f42250g.g());
            this.o.j(!this.f42250g.f());
            this.f42252i.c(this.o);
        }
    }

    @Override // d.a.h0.a.g.a
    public void onAdLogoClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // d.a.h0.a.g.c
    public void onAdStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.j = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adShowScene", this.f42250g.C);
                jSONObject.put("adSplashType", this.f42250g.f42284e);
                if (this.f42250g.C == 1) {
                    jSONObject.put("adLoadCostTime", this.k - this.l);
                }
                jSONObject.put("adRenderCostTime", this.j - this.l);
            } catch (JSONException e2) {
                if (d.a.e0.a.a.a.f42207a) {
                    e2.printStackTrace();
                }
            }
            this.f42251h.b(jSONObject);
            d.a.e0.b.g.f.y(this.f42250g);
            j.c(this.f42250g);
            d dVar = this.f42252i;
            if (dVar != null) {
                dVar.onAdShow();
            }
        }
    }

    @Override // d.a.h0.a.g.c
    public void onAdStop(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.m = System.currentTimeMillis() - this.j;
            if ("time_end".equals(str)) {
                b(Als.CloseType.COUNTDOWN_TIME_FINISH.value);
            } else if ("click_skip_button".equals(str)) {
                b(Als.CloseType.CLICK_SKIP_BUTTON.value);
            } else if ("click_ad_area".equals(str)) {
                b(Als.CloseType.CLICK_AD_AREA.value);
            } else {
                b(Als.CloseType.OTHER.value);
            }
            if (this.f42252i != null) {
                d.a.h0.a.k.a.a(new a(this));
            }
        }
    }

    @Override // d.a.h0.a.g.a
    public void onPermissionClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // d.a.h0.a.g.a
    public void onPrivacyClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // d.a.h0.a.g.a
    public void onSkipClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d dVar = this.f42252i;
            if (dVar != null) {
                dVar.onSkip();
            }
            b(Als.CloseType.CLICK_SKIP_BUTTON.value);
        }
    }
}
