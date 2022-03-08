package com.dxmpay.apollon.base.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.imagemanager.ImageLoader;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class NetImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static String f52157b;

    /* renamed from: c  reason: collision with root package name */
    public static String f52158c;

    /* renamed from: d  reason: collision with root package name */
    public static String f52159d;

    /* renamed from: e  reason: collision with root package name */
    public static String f52160e;

    /* renamed from: f  reason: collision with root package name */
    public static String f52161f;

    /* renamed from: g  reason: collision with root package name */
    public static String f52162g;

    /* renamed from: h  reason: collision with root package name */
    public static String f52163h;

    /* renamed from: i  reason: collision with root package name */
    public static String f52164i;

    /* renamed from: j  reason: collision with root package name */
    public static Handler f52165j;
    public static HashMap<String, Integer> k;
    public transient /* synthetic */ FieldHolder $fh;
    public String l;
    public Drawable m;
    public Drawable n;
    public boolean o;
    public int p;
    public int q;
    public ImageView.ScaleType r;
    public boolean s;
    public int t;
    public ImageLoader.OnGetBitmapListener u;

    /* loaded from: classes7.dex */
    public static class a implements ImageLoader.OnGetBitmapListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<NetImageView> a;

        public a(NetImageView netImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {netImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(netImageView);
        }

        @Override // com.dxmpay.apollon.imagemanager.ImageLoader.OnGetBitmapListener
        public boolean needCancel(String str, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, obj)) == null) {
                WeakReference<NetImageView> weakReference = this.a;
                boolean z = false;
                if (weakReference != null) {
                    NetImageView netImageView = weakReference.get();
                    if (netImageView == null) {
                        return false;
                    }
                    z = (netImageView.n == null && TextUtils.equals(str, netImageView.l)) ? true : true;
                    if (NetImageView.a && z) {
                        String str2 = "Canceled   url: " + str;
                    }
                }
                return z;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.dxmpay.apollon.imagemanager.ImageLoader.OnGetBitmapListener
        public void onError(String str, Object obj) {
            NetImageView netImageView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) && NetImageView.a) {
                String str2 = "getImage error: " + str;
                WeakReference<NetImageView> weakReference = this.a;
                if (weakReference == null || (netImageView = weakReference.get()) == null) {
                    return;
                }
                netImageView.post(new Runnable(this, netImageView, str) { // from class: com.dxmpay.apollon.base.widget.NetImageView.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ NetImageView a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f52169b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f52170c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, netImageView, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f52170c = this;
                        this.a = netImageView;
                        this.f52169b = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && TextUtils.equals(this.a.l, this.f52169b)) {
                            this.a.onLoadUrlError(true);
                        }
                    }
                });
            }
        }

        @Override // com.dxmpay.apollon.imagemanager.ImageLoader.OnGetBitmapListener
        public void onGetBitmap(String str, Object obj, Bitmap bitmap) {
            WeakReference<NetImageView> weakReference;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, obj, bitmap) == null) || (weakReference = this.a) == null) {
                return;
            }
            NetImageView netImageView = weakReference.get();
            if (NetImageView.f52165j == null || netImageView == null) {
                return;
            }
            NetImageView.f52165j.post(new Runnable(this, netImageView, str, bitmap) { // from class: com.dxmpay.apollon.base.widget.NetImageView.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NetImageView a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f52166b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Bitmap f52167c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ a f52168d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, netImageView, str, bitmap};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f52168d = this;
                    this.a = netImageView;
                    this.f52166b = str;
                    this.f52167c = bitmap;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.setRemoteDrawable(this.f52166b, this.f52167c);
                    }
                }
            });
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-839111915, "Lcom/dxmpay/apollon/base/widget/NetImageView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-839111915, "Lcom/dxmpay/apollon/base/widget/NetImageView;");
                return;
            }
        }
        a = ApollonConstants.DEBUG & true;
        f52157b = "ldpi";
        f52158c = "mdpi";
        f52159d = "hdpi";
        f52160e = "xhdpi";
        f52161f = "xxhdpi";
        f52162g = "xxxhdpi";
        f52163h = "tvdpi";
        f52164i = "density";
        HashMap<String, Integer> hashMap = new HashMap<>();
        k = hashMap;
        hashMap.put(f52157b, 120);
        k.put(f52158c, 160);
        k.put(f52163h, 213);
        k.put(f52159d, 240);
        k.put(f52160e, Integer.valueOf((int) MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP));
        k.put(f52161f, 480);
        k.put(f52162g, 640);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.s = false;
        this.u = new a(this);
        setDensity(attributeSet);
        a(context);
    }

    private void c() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (layoutParams = getLayoutParams()) == null) {
            return;
        }
        int i2 = this.p;
        if (i2 != Integer.MIN_VALUE) {
            layoutParams.width = i2;
        }
        int i3 = this.q;
        if (i3 != Integer.MIN_VALUE) {
            layoutParams.height = i3;
        }
    }

    private void setDensity(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, attributeSet) == null) || attributeSet == null) {
            return;
        }
        String attributeValue = attributeSet.getAttributeValue(null, f52164i);
        if (TextUtils.isEmpty(attributeValue)) {
            return;
        }
        Integer num = k.get(attributeValue.trim().toLowerCase());
        if (num != null) {
            this.t = num.intValue();
        }
    }

    public void callRealSetImageDrawable(Drawable drawable, boolean z) {
        Drawable drawable2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, drawable, z) == null) {
            if (hasRemoteDrawableDone() && (drawable2 = this.n) != null) {
                super.setImageDrawable(drawable2);
                return;
            }
            c();
            if (drawable != null) {
                super.setImageDrawable(drawable);
            }
            if (z) {
                requestLoadingRemoteImage();
            }
        }
    }

    public boolean hasRemoteDrawableDone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n != null : invokeV.booleanValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.s) {
                releaseRemoteDrawable();
            }
            this.u = null;
            super.onDetachedFromWindow();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            if (!this.o && !hasRemoteDrawableDone()) {
                requestLoadingRemoteImage();
            }
            super.onDraw(canvas);
        }
    }

    public void onLoadUrlError(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
        }
    }

    public void releaseRemoteDrawable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.l = null;
            this.n = null;
            callRealSetImageDrawable(this.m, false);
        }
    }

    public void requestLoadingRemoteImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (hasRemoteDrawableDone()) {
                callRealSetImageDrawable(this.n, false);
            } else if (this.o || TextUtils.isEmpty(this.l)) {
            } else {
                ImageLoader.getInstance(getContext()).getBitmapFromDiskOrNet(this.l, this.u, null, this.t);
                this.o = true;
            }
        }
    }

    public void setDefaultSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            this.p = i2;
            this.q = i3;
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, drawable) == null) {
            super.setImageDrawable(drawable);
            this.l = null;
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.l = null;
            try {
                this.m = getResources().getDrawable(i2);
            } catch (Exception unused) {
                this.m = null;
            }
            Drawable drawable = this.m;
            setImageDrawable(drawable != null ? drawable : null);
        }
    }

    public void setImageUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            setImageUrl(str, true);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, layoutParams) == null) {
            super.setLayoutParams(layoutParams);
            c();
        }
    }

    public void setReleaseWhenDetachFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.s = z;
        }
    }

    public void setRemoteDrawable(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, str, bitmap) == null) && this.n == null && TextUtils.equals(str, this.l)) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
            this.n = bitmapDrawable;
            callRealSetImageDrawable(bitmapDrawable, false);
            if (a) {
                String str2 = "getImage ok: " + this.n.getIntrinsicWidth() + "x" + this.n.getIntrinsicHeight() + " url: " + str;
            }
        }
    }

    public void setImageUrl(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, str, z) == null) {
            if (TextUtils.isEmpty(str)) {
                this.l = null;
            } else if (TextUtils.equals(this.l, str)) {
            } else {
                if (a) {
                    String str2 = "req: " + z + " img url: " + str;
                }
                this.l = str;
                this.n = null;
                this.o = false;
                Bitmap bitmapFromMemCache = ImageLoader.getInstance(getContext()).getBitmapFromMemCache(this.l);
                if (bitmapFromMemCache != null) {
                    setRemoteDrawable(this.l, bitmapFromMemCache);
                } else {
                    callRealSetImageDrawable(this.m, z);
                }
            }
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, context) == null) {
            if (f52165j == null) {
                synchronized (NetImageView.class) {
                    if (f52165j == null) {
                        f52165j = new Handler(context.getMainLooper());
                    }
                }
            }
            if (this.r == null) {
                this.r = ImageView.ScaleType.FIT_CENTER;
            }
            this.p = Integer.MIN_VALUE;
            this.q = Integer.MIN_VALUE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.s = false;
        this.u = new a(this);
        setDensity(attributeSet);
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetImageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.s = false;
        this.u = new a(this);
        a(context);
    }
}
