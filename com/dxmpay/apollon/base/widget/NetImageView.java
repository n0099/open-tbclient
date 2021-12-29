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
/* loaded from: classes2.dex */
public class NetImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public static String p;
    public static String q;
    public static String r;
    public static String s;
    public static String t;
    public static String u;
    public static String v;
    public static String w;
    public static Handler x;
    public static HashMap<String, Integer> y;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f55631e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f55632f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f55633g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55634h;

    /* renamed from: i  reason: collision with root package name */
    public int f55635i;

    /* renamed from: j  reason: collision with root package name */
    public int f55636j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView.ScaleType f55637k;
    public boolean l;
    public int m;
    public ImageLoader.OnGetBitmapListener n;

    /* loaded from: classes2.dex */
    public static class a implements ImageLoader.OnGetBitmapListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<NetImageView> a;

        /* renamed from: com.dxmpay.apollon.base.widget.NetImageView$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC2037a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ NetImageView f55638e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f55639f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Bitmap f55640g;

            public RunnableC2037a(a aVar, NetImageView netImageView, String str, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, netImageView, str, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55638e = netImageView;
                this.f55639f = str;
                this.f55640g = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f55638e.setRemoteDrawable(this.f55639f, this.f55640g);
                }
            }
        }

        /* loaded from: classes2.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ NetImageView f55641e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f55642f;

            public b(a aVar, NetImageView netImageView, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, netImageView, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55641e = netImageView;
                this.f55642f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && TextUtils.equals(this.f55641e.f55631e, this.f55642f)) {
                    this.f55641e.onLoadUrlError(true);
                }
            }
        }

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
                    z = (netImageView.f55633g == null && TextUtils.equals(str, netImageView.f55631e)) ? true : true;
                    if (NetImageView.o && z) {
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
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) && NetImageView.o) {
                String str2 = "getImage error: " + str;
                WeakReference<NetImageView> weakReference = this.a;
                if (weakReference == null || (netImageView = weakReference.get()) == null) {
                    return;
                }
                netImageView.post(new b(this, netImageView, str));
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
            if (NetImageView.x == null || netImageView == null) {
                return;
            }
            NetImageView.x.post(new RunnableC2037a(this, netImageView, str, bitmap));
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
        o = ApollonConstants.DEBUG & true;
        p = "ldpi";
        q = "mdpi";
        r = "hdpi";
        s = "xhdpi";
        t = "xxhdpi";
        u = "xxxhdpi";
        v = "tvdpi";
        w = "density";
        HashMap<String, Integer> hashMap = new HashMap<>();
        y = hashMap;
        hashMap.put(p, 120);
        y.put(q, 160);
        y.put(v, 213);
        y.put(r, 240);
        y.put(s, Integer.valueOf((int) MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP));
        y.put(t, 480);
        y.put(u, 640);
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
        this.l = false;
        this.n = new a(this);
        setDensity(attributeSet);
        c(context);
    }

    private void setDensity(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, attributeSet) == null) || attributeSet == null) {
            return;
        }
        String attributeValue = attributeSet.getAttributeValue(null, w);
        if (TextUtils.isEmpty(attributeValue)) {
            return;
        }
        Integer num = y.get(attributeValue.trim().toLowerCase());
        if (num != null) {
            this.m = num.intValue();
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            if (x == null) {
                synchronized (NetImageView.class) {
                    if (x == null) {
                        x = new Handler(context.getMainLooper());
                    }
                }
            }
            if (this.f55637k == null) {
                this.f55637k = ImageView.ScaleType.FIT_CENTER;
            }
            this.f55635i = Integer.MIN_VALUE;
            this.f55636j = Integer.MIN_VALUE;
        }
    }

    public void callRealSetImageDrawable(Drawable drawable, boolean z) {
        Drawable drawable2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable, z) == null) {
            if (hasRemoteDrawableDone() && (drawable2 = this.f55633g) != null) {
                super.setImageDrawable(drawable2);
                return;
            }
            f();
            if (drawable != null) {
                super.setImageDrawable(drawable);
            }
            if (z) {
                requestLoadingRemoteImage();
            }
        }
    }

    public final void f() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (layoutParams = getLayoutParams()) == null) {
            return;
        }
        int i2 = this.f55635i;
        if (i2 != Integer.MIN_VALUE) {
            layoutParams.width = i2;
        }
        int i3 = this.f55636j;
        if (i3 != Integer.MIN_VALUE) {
            layoutParams.height = i3;
        }
    }

    public boolean hasRemoteDrawableDone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f55633g != null : invokeV.booleanValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.l) {
                releaseRemoteDrawable();
            }
            this.n = null;
            super.onDetachedFromWindow();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            if (!this.f55634h && !hasRemoteDrawableDone()) {
                requestLoadingRemoteImage();
            }
            super.onDraw(canvas);
        }
    }

    public void onLoadUrlError(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    public void releaseRemoteDrawable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f55631e = null;
            this.f55633g = null;
            callRealSetImageDrawable(this.f55632f, false);
        }
    }

    public void requestLoadingRemoteImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (hasRemoteDrawableDone()) {
                callRealSetImageDrawable(this.f55633g, false);
            } else if (this.f55634h || TextUtils.isEmpty(this.f55631e)) {
            } else {
                ImageLoader.getInstance(getContext()).getBitmapFromDiskOrNet(this.f55631e, this.n, null, this.m);
                this.f55634h = true;
            }
        }
    }

    public void setDefaultSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            this.f55635i = i2;
            this.f55636j = i3;
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, drawable) == null) {
            super.setImageDrawable(drawable);
            this.f55631e = null;
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f55631e = null;
            try {
                this.f55632f = getResources().getDrawable(i2);
            } catch (Exception unused) {
                this.f55632f = null;
            }
            Drawable drawable = this.f55632f;
            setImageDrawable(drawable != null ? drawable : null);
        }
    }

    public void setImageUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            setImageUrl(str, true);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, layoutParams) == null) {
            super.setLayoutParams(layoutParams);
            f();
        }
    }

    public void setReleaseWhenDetachFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.l = z;
        }
    }

    public void setRemoteDrawable(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, str, bitmap) == null) && this.f55633g == null && TextUtils.equals(str, this.f55631e)) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
            this.f55633g = bitmapDrawable;
            callRealSetImageDrawable(bitmapDrawable, false);
            if (o) {
                String str2 = "getImage ok: " + this.f55633g.getIntrinsicWidth() + "x" + this.f55633g.getIntrinsicHeight() + " url: " + str;
            }
        }
    }

    public void setImageUrl(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, str, z) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f55631e = null;
            } else if (TextUtils.equals(this.f55631e, str)) {
            } else {
                if (o) {
                    String str2 = "req: " + z + " img url: " + str;
                }
                this.f55631e = str;
                this.f55633g = null;
                this.f55634h = false;
                Bitmap bitmapFromMemCache = ImageLoader.getInstance(getContext()).getBitmapFromMemCache(this.f55631e);
                if (bitmapFromMemCache != null) {
                    setRemoteDrawable(this.f55631e, bitmapFromMemCache);
                } else {
                    callRealSetImageDrawable(this.f55632f, z);
                }
            }
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
        this.l = false;
        this.n = new a(this);
        setDensity(attributeSet);
        c(context);
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
        this.l = false;
        this.n = new a(this);
        c(context);
    }
}
