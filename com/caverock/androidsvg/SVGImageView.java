package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
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

    /* renamed from: e  reason: collision with root package name */
    public static Method f69347e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public class b extends AsyncTask<String, Integer, Picture> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SVGImageView f69348a;

        public b(SVGImageView sVGImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVGImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69348a = sVGImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Picture doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                try {
                    return SVG.f(this.f69348a.getContext().getAssets(), strArr[0]).l();
                } catch (SVGParseException e2) {
                    String str = "Error loading file " + strArr + ": " + e2.getMessage();
                    return null;
                } catch (FileNotFoundException unused) {
                    String str2 = "File not found: " + strArr;
                    return null;
                } catch (IOException unused2) {
                    String str3 = "Unable to load asset file: " + strArr;
                    return null;
                }
            }
            return (Picture) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Picture picture) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, picture) == null) || picture == null) {
                return;
            }
            this.f69348a.d();
            this.f69348a.setImageDrawable(new PictureDrawable(picture));
        }

        public /* synthetic */ b(SVGImageView sVGImageView, a aVar) {
            this(sVGImageView);
        }
    }

    /* loaded from: classes9.dex */
    public class c extends AsyncTask<Integer, Integer, Picture> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SVGImageView f69349a;

        public c(SVGImageView sVGImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVGImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69349a = sVGImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Picture doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                try {
                    return SVG.h(this.f69349a.getContext(), numArr[0].intValue()).l();
                } catch (SVGParseException e2) {
                    String.format("Error loading resource 0x%x: %s", numArr, e2.getMessage());
                    return null;
                }
            }
            return (Picture) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Picture picture) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, picture) == null) || picture == null) {
                return;
            }
            this.f69349a.d();
            this.f69349a.setImageDrawable(new PictureDrawable(picture));
        }

        public /* synthetic */ c(SVGImageView sVGImageView, a aVar) {
            this(sVGImageView);
        }
    }

    /* loaded from: classes9.dex */
    public class d extends AsyncTask<InputStream, Integer, Picture> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SVGImageView f69350a;

        public d(SVGImageView sVGImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVGImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69350a = sVGImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Picture doInBackground(InputStream... inputStreamArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, inputStreamArr)) == null) {
                try {
                    try {
                        Picture l = SVG.g(inputStreamArr[0]).l();
                        try {
                            inputStreamArr[0].close();
                        } catch (IOException unused) {
                        }
                        return l;
                    } catch (SVGParseException e2) {
                        String str = "Parse error loading URI: " + e2.getMessage();
                        try {
                            inputStreamArr[0].close();
                            return null;
                        } catch (IOException unused2) {
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    try {
                        inputStreamArr[0].close();
                    } catch (IOException unused3) {
                    }
                    throw th;
                }
            }
            return (Picture) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Picture picture) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, picture) == null) || picture == null) {
                return;
            }
            this.f69350a.d();
            this.f69350a.setImageDrawable(new PictureDrawable(picture));
        }

        public /* synthetic */ d(SVGImageView sVGImageView, a aVar) {
            this(sVGImageView);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1578512680, "Lcom/caverock/androidsvg/SVGImageView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1578512680, "Lcom/caverock/androidsvg/SVGImageView;");
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        try {
            f69347e = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException unused) {
        }
    }

    public final void b(AttributeSet attributeSet, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, attributeSet, i2) == null) || isInEditMode()) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, c.a.q.a.a.SVGImageView, i2, 0);
        try {
            int resourceId = obtainStyledAttributes.getResourceId(c.a.q.a.a.SVGImageView_svg, -1);
            if (resourceId != -1) {
                setImageResource(resourceId);
                return;
            }
            String string = obtainStyledAttributes.getString(c.a.q.a.a.SVGImageView_svg);
            if (string != null) {
                if (c(Uri.parse(string), false)) {
                    return;
                }
                setImageAsset(string);
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final boolean c(Uri uri, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, z)) == null) {
            try {
                new d(this, null).execute(getContext().getContentResolver().openInputStream(uri));
                return true;
            } catch (FileNotFoundException unused) {
                if (z) {
                    String str = "File not found: " + uri;
                }
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || f69347e == null) {
            return;
        }
        try {
            f69347e.invoke(this, Integer.valueOf(View.class.getField("LAYER_TYPE_SOFTWARE").getInt(new View(getContext()))), null);
        } catch (Exception unused) {
        }
    }

    public void setImageAsset(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            new b(this, null).execute(str);
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            new c(this, null).execute(Integer.valueOf(i2));
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, uri) == null) {
            c(uri, true);
        }
    }

    public void setSVG(SVG svg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, svg) == null) {
            if (svg != null) {
                d();
                setImageDrawable(new PictureDrawable(svg.l()));
                return;
            }
            throw new IllegalArgumentException("Null value passed to setSVG()");
        }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        try {
            f69347e = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException unused) {
        }
        b(attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGImageView(Context context, AttributeSet attributeSet, int i2) {
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
        try {
            f69347e = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException unused) {
        }
        b(attributeSet, i2);
    }
}
