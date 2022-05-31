package com.repackage;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class jo9 extends AsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ File a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ Bitmap.CompressFormat c;
    public final /* synthetic */ gq9 d;

    public jo9(File file, Bitmap bitmap, Bitmap.CompressFormat compressFormat, gq9 gq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, bitmap, compressFormat, gq9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = file;
        this.b = bitmap;
        this.c = compressFormat;
        this.d = gq9Var;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x003b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0007 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:9:0x001e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v6, types: [android.graphics.Bitmap] */
    @Override // android.os.AsyncTask
    public Object doInBackground(Object[] objArr) {
        Throwable th;
        IOException e;
        Interceptable interceptable = $ic;
        InterceptResult e2 = interceptable;
        if (interceptable != null) {
            InterceptResult invokeL = interceptable.invokeL(1048576, this, objArr);
            e2 = invokeL;
            if (invokeL != null) {
                return invokeL.objValue;
            }
        }
        Void[] voidArr = (Void[]) objArr;
        FileOutputStream fileOutputStream = null;
        try {
        } catch (Throwable th2) {
            FileOutputStream fileOutputStream2 = e2;
            th = th2;
            fileOutputStream = fileOutputStream2;
        }
        try {
            try {
                e2 = new FileOutputStream(this.a);
            } catch (IOException e3) {
                e2 = e3;
                e2.printStackTrace();
            }
            try {
                this.b.compress(this.c, 100, e2);
                e2.flush();
                e2.close();
                e2 = e2;
            } catch (IOException e4) {
                e = e4;
                new com.win.opensdk.k0(e);
                cancel(true);
                if (e2 != 0) {
                    e2.flush();
                    e2.close();
                    e2 = e2;
                }
                return null;
            }
        } catch (IOException e5) {
            e = e5;
            e2 = 0;
        } catch (Throwable th3) {
            th = th3;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d.a();
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            Void r5 = (Void) obj;
            this.d.b();
        }
    }
}
