package com.repackage;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.switchs.AsyncGetClipboardSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class be5 {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] g;
    public static final String[] h;
    public static final String[] i;
    public static Point j;
    public static final List<String> k;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public d b;
    public long c;
    public c d;
    public c e;
    public final Handler f;

    /* loaded from: classes5.dex */
    public class a extends de5<Cursor> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Uri a;
        public final /* synthetic */ be5 b;

        public a(be5 be5Var, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {be5Var, uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = be5Var;
            this.a = uri;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.de5
        /* renamed from: a */
        public Cursor doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    return this.b.a.getContentResolver().query(this.a, Build.VERSION.SDK_INT < 16 ? be5.g : be5.h, null, null, "date_added desc limit 1");
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return (Cursor) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements jd5<Cursor> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ be5 a;

        public b(be5 be5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {be5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = be5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jd5
        /* renamed from: a */
        public void onReturnDataInUI(Cursor cursor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cursor) == null) {
                this.a.k(cursor);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Uri a;
        public final /* synthetic */ be5 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(be5 be5Var, Uri uri, Handler handler) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {be5Var, uri, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = be5Var;
            this.a = uri;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.onChange(z);
                this.b.j(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void onShot(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755829857, "Lcom/repackage/be5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755829857, "Lcom/repackage/be5;");
                return;
            }
        }
        g = new String[]{"_data", "datetaken"};
        h = new String[]{"_data", "datetaken", "width", "height"};
        i = new String[]{StatisticConstants.SCREENSHOT, "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};
        k = new ArrayList();
    }

    public be5(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = new Handler(Looper.getMainLooper());
        this.a = context;
        if (j == null) {
            Point i4 = i();
            j = i4;
            if (i4 != null) {
                BdLog.d("ScreenShotListenManager: Screen Real Size: " + j.x + " * " + j.y);
                return;
            }
            BdLog.d("ScreenShotListenManager: Get screen real size failed.");
        }
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? Looper.myLooper() == Looper.getMainLooper() : invokeV.booleanValue;
    }

    public final boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (k.contains(str)) {
                BdLog.d("ScreenShotListenManager: ScreenShot: imgPath has done; imagePath = " + str);
                return true;
            }
            if (k.size() >= 20) {
                for (int i2 = 0; i2 < 5; i2++) {
                    k.remove(0);
                }
            }
            k.add(str);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean g(String str, long j2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (j2 >= this.c && System.currentTimeMillis() - j2 <= 10000) {
                Point point = j;
                if (point != null && (i2 > point.x || i3 > point.y)) {
                    Point point2 = j;
                    if (i3 > point2.x || i2 > point2.y) {
                        return false;
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                String lowerCase = str.toLowerCase();
                for (String str2 : i) {
                    if (lowerCase.contains(str2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final Point h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            return new Point(options.outWidth, options.outHeight);
        }
        return (Point) invokeL.objValue;
    }

    public final Point i() {
        InterceptResult invokeV;
        Exception e;
        Point point;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!m() || this.a == null) {
                return null;
            }
            try {
                point = new Point();
            } catch (Exception e2) {
                e = e2;
                point = null;
            }
            try {
                Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
                if (Build.VERSION.SDK_INT >= 17) {
                    defaultDisplay.getRealSize(point);
                } else {
                    try {
                        point.set(((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue(), ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue());
                    } catch (Exception e3) {
                        point.set(defaultDisplay.getWidth(), defaultDisplay.getHeight());
                        BdLog.e(e3);
                    }
                }
            } catch (Exception e4) {
                e = e4;
                BdLog.e(e);
                return point;
            }
            return point;
        }
        return (Point) invokeV.objValue;
    }

    public final void j(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, uri) == null) {
            if (AsyncGetClipboardSwitch.isOn()) {
                he5.b(new a(this, uri), new b(this));
                return;
            }
            Cursor cursor = null;
            try {
                cursor = this.a.getContentResolver().query(uri, Build.VERSION.SDK_INT < 16 ? g : h, null, null, "date_added desc limit 1");
            } catch (Exception e) {
                e.printStackTrace();
            }
            k(cursor);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    public final void k(Cursor cursor) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cursor) == null) {
            try {
                if (cursor == null) {
                    if (cursor == null || cursor.isClosed()) {
                        return;
                    }
                    cursor.close();
                    return;
                }
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                    if (cursor == null || cursor.isClosed()) {
                        return;
                    }
                }
                if (!cursor.moveToFirst()) {
                    if (cursor == null || cursor.isClosed()) {
                        return;
                    }
                    cursor.close();
                    return;
                }
                int columnIndex = cursor.getColumnIndex("_data");
                int columnIndex2 = cursor.getColumnIndex("datetaken");
                int i5 = -1;
                if (Build.VERSION.SDK_INT >= 16) {
                    i5 = cursor.getColumnIndex("width");
                    i2 = cursor.getColumnIndex("height");
                } else {
                    i2 = -1;
                }
                String string = cursor.getString(columnIndex);
                long j2 = cursor.getLong(columnIndex2);
                if (i5 >= 0 && i2 >= 0) {
                    i4 = cursor.getInt(i5);
                    i3 = cursor.getInt(i2);
                } else {
                    Point h2 = h(string);
                    int i6 = h2.x;
                    i3 = h2.y;
                    i4 = i6;
                }
                l(string, j2, i4, i3);
                if (cursor == null || cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    public final void l(String str, long j2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (g(str, j2, i2, i3)) {
                BdLog.d("ScreenShotListenManager: ScreenShot: path = " + str + "; size = " + i2 + " * " + i3 + "; date = " + j2);
                if (this.b == null || f(str)) {
                    return;
                }
                this.b.onShot(str);
                return;
            }
            BdLog.d("ScreenShotListenManager: Media content changed, but not screenshot: path = " + str + "; size = " + i2 + " * " + i3 + "; date = " + j2);
        }
    }

    public void n(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.b = dVar;
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && m() && PermissionUtil.isAgreePrivacyPolicy()) {
            this.c = System.currentTimeMillis();
            this.d = new c(this, MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.f);
            this.e = new c(this, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.f);
            if (Build.VERSION.SDK_INT >= 29) {
                this.a.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, true, this.d);
                this.a.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.e);
                return;
            }
            this.a.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, false, this.d);
            this.a.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.e);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && m()) {
            if (this.d != null) {
                try {
                    this.a.getContentResolver().unregisterContentObserver(this.d);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.d = null;
            }
            if (this.e != null) {
                try {
                    this.a.getContentResolver().unregisterContentObserver(this.e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.e = null;
            }
            this.c = 0L;
            this.b = null;
        }
    }
}
