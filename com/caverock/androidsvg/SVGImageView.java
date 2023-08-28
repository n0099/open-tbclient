package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pjb;
import com.baidu.tieba.qjb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
/* loaded from: classes9.dex */
public class SVGImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public static Method c;
    public transient /* synthetic */ FieldHolder $fh;
    public SVG a;
    public qjb b;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public class b extends AsyncTask<Integer, Integer, SVG> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public int b;
        public final /* synthetic */ SVGImageView c;

        public b(SVGImageView sVGImageView, Context context, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVGImageView, context, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sVGImageView;
            this.a = context;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public SVG doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                try {
                    return SVG.i(this.a, this.b);
                } catch (SVGParseException e) {
                    Log.e("SVGImageView", String.format("Error loading resource 0x%x: %s", Integer.valueOf(this.b), e.getMessage()));
                    return null;
                }
            }
            return (SVG) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(SVG svg) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, svg) != null) {
                return;
            }
            this.c.a = svg;
            this.c.c();
        }
    }

    /* loaded from: classes9.dex */
    public class c extends AsyncTask<InputStream, Integer, SVG> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SVGImageView a;

        public c(SVGImageView sVGImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVGImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVGImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(SVG svg) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, svg) != null) {
                return;
            }
            this.a.a = svg;
            this.a.c();
        }

        public /* synthetic */ c(SVGImageView sVGImageView, a aVar) {
            this(sVGImageView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public SVG doInBackground(InputStream... inputStreamArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, inputStreamArr)) == null) {
                try {
                    try {
                        SVG h = SVG.h(inputStreamArr[0]);
                        try {
                            inputStreamArr[0].close();
                        } catch (IOException unused) {
                        }
                        return h;
                    } catch (Throwable th) {
                        try {
                            inputStreamArr[0].close();
                        } catch (IOException unused2) {
                        }
                        throw th;
                    }
                } catch (SVGParseException e) {
                    Log.e("SVGImageView", "Parse error loading URI: " + e.getMessage());
                    try {
                        inputStreamArr[0].close();
                        return null;
                    } catch (IOException unused3) {
                        return null;
                    }
                }
            }
            return (SVG) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1578512680, "Lcom/caverock/androidsvg/SVGImageView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1578512680, "Lcom/caverock/androidsvg/SVGImageView;");
                return;
            }
        }
        try {
            c = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException unused) {
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || c == null) {
            return;
        }
        try {
            c.invoke(this, Integer.valueOf(View.class.getField("LAYER_TYPE_SOFTWARE").getInt(new View(getContext()))), null);
        } catch (Exception e) {
            Log.w("SVGImageView", "Unexpected failure calling setLayerType", e);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGImageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = new qjb();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = new qjb();
        d(attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = new qjb();
        d(attributeSet, i);
    }

    public void setSVG(SVG svg, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, svg, str) == null) {
            if (svg != null) {
                this.a = svg;
                this.b.a(str);
                c();
                return;
            }
            throw new IllegalArgumentException("Null value passed to setSVG()");
        }
    }

    private void setFromString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, str) == null) {
            try {
                this.a = SVG.k(str);
                c();
            } catch (SVGParseException unused) {
                Log.e("SVGImageView", "Could not find SVG at: " + str);
            }
        }
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                new c(this, null).execute(getContext().getAssets().open(str));
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean f(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, uri)) == null) {
            try {
                new c(this, null).execute(getContext().getContentResolver().openInputStream(uri));
                return true;
            } catch (FileNotFoundException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void setCSS(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.b.a(str);
            c();
        }
    }

    public void setImageAsset(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && !e(str)) {
            Log.e("SVGImageView", "File not found: " + str);
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            new b(this, getContext(), i).execute(new Integer[0]);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uri) == null) && !f(uri)) {
            Log.e("SVGImageView", "File not found: " + uri);
        }
    }

    public void setSVG(SVG svg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, svg) == null) {
            if (svg != null) {
                this.a = svg;
                c();
                return;
            }
            throw new IllegalArgumentException("Null value passed to setSVG()");
        }
    }

    public final void c() {
        SVG svg;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (svg = this.a) == null) {
            return;
        }
        Picture o = svg.o(this.b);
        g();
        setImageDrawable(new PictureDrawable(o));
    }

    public final void d(AttributeSet attributeSet, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, attributeSet, i) != null) || isInEditMode()) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, pjb.SVGImageView, i, 0);
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                this.b.a(string);
            }
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            if (resourceId != -1) {
                setImageResource(resourceId);
                return;
            }
            String string2 = obtainStyledAttributes.getString(1);
            if (string2 != null) {
                if (f(Uri.parse(string2))) {
                    return;
                }
                if (e(string2)) {
                    return;
                }
                setFromString(string2);
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
