package d.a.i0.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sdk.container.filedownloader.MaterialLoadErrorCode;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import com.baidu.sdk.container.widget.AdView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends d.a.i0.a.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView N;
    public Bitmap O;

    /* loaded from: classes7.dex */
    public class a implements d.a.i0.a.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f42976a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42976a = cVar;
        }

        @Override // d.a.i0.a.e.a
        public void a(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, view, materialLoadErrorCode) == null) {
                c cVar = this.f42976a;
                cVar.D("StaticImage Load Failed: " + materialLoadErrorCode.toString());
            }
        }

        @Override // d.a.i0.a.e.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view, bitmap) == null) {
                this.f42976a.O = bitmap;
                this.f42976a.M();
                this.f42976a.E();
            }
        }

        @Override // d.a.i0.a.e.a
        public void onLoadingStarted(String str, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, view) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f42977e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42977e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f42977e.C();
            }
        }
    }

    /* renamed from: d.a.i0.a.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0609c implements d.a.i0.a.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f42978a;

        public C0609c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42978a = cVar;
        }

        @Override // d.a.i0.a.e.a
        public void a(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, view, materialLoadErrorCode) == null) {
                c cVar = this.f42978a;
                cVar.D("Get Static Image error: " + materialLoadErrorCode.getMessage());
            }
        }

        @Override // d.a.i0.a.e.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view, bitmap) == null) {
                this.f42978a.O = bitmap;
            }
        }

        @Override // d.a.i0.a.e.a
        public void onLoadingStarted(String str, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, view) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, JSONObject jSONObject) {
        super(context, jSONObject);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (JSONObject) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = "image";
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ImageView imageView = this.N;
            if (imageView != null) {
                imageView.setScaleType(this.G == 17 ? ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_XY);
            }
            if (this.O != null) {
                return;
            }
            this.O = this.f42955i.a(this.u, new C0609c(this));
        }
    }

    @Override // d.a.i0.a.d.a, d.a.i0.a.g.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.a();
            if (this.f42955i.c(this.u, MaterialLoader.MaterialCacheType.PICTURE)) {
                M();
                E();
                return;
            }
            try {
                MaterialLoader.k(this.f42947a).f(this.u, new a(this));
            } catch (Exception e2) {
                D("StaticImage,Exception: " + e2.toString());
            }
        }
    }

    @Override // d.a.i0.a.d.a, d.a.i0.a.g.b
    public void b(d.a.i0.a.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            super.b(cVar);
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
        }
    }

    @Override // d.a.i0.a.d.a, d.a.i0.a.g.b
    public void d(d.a.i0.a.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            super.d(aVar);
        }
    }

    @Override // d.a.i0.a.d.a, d.a.i0.a.g.b
    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? super.getAdView() : (View) invokeV.objValue;
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            N();
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, keyEvent)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
        }
    }

    @Override // d.a.i0.a.d.a
    public void v() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (imageView = this.N) == null) {
            return;
        }
        imageView.setOnClickListener(null);
    }

    @Override // d.a.i0.a.d.a
    public void y() {
        RelativeLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.f42948b != 2) {
                try {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    ImageView imageView = new ImageView(this.f42947a);
                    this.N = imageView;
                    imageView.setVisibility(0);
                    this.N.setOnClickListener(new b(this));
                    this.N.setLayoutParams(layoutParams);
                    P();
                } catch (Exception e2) {
                    this.f42952f.c(d.a.i0.a.d.a.M, e2);
                    D(d.a.i0.a.d.a.M + " exception=" + Log.getStackTraceString(e2));
                }
                if (this.O == null) {
                    return;
                }
                this.N.setDrawingCacheEnabled(true);
                this.N.setImageBitmap(this.O);
                j(this.N, layoutParams);
                this.N.requestLayout();
                super.y();
                this.N.requestFocus();
                G();
                return;
            }
            this.f42952f.a("XPureStaticImageAdContainer: ad state is stopped, so can not show ad");
        }
    }

    @Override // d.a.i0.a.d.a
    public void z() {
        AdView adView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f42952f.j(d.a.i0.a.d.a.M, "doStopOnUIThread");
            ImageView imageView = this.N;
            if (imageView != null && (adView = this.l) != null && adView.indexOfChild(imageView) >= 0) {
                this.f42952f.j(d.a.i0.a.d.a.M, "doStopOnUIThread release imageView");
                if (this.N.getDrawingCache() != null) {
                    this.N.getDrawingCache().recycle();
                }
                this.l.removeAllViews();
            }
            Bitmap bitmap = this.O;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            d.a.i0.a.k.b bVar = this.f42952f;
            String str = d.a.i0.a.d.a.M;
            bVar.j(str, "doStopOnUIThread release newBitmap->" + this.O.toString());
            this.O.recycle();
            this.O = null;
        }
    }
}
