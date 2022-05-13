package com.repackage;

import android.content.Context;
import android.os.AsyncTask;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class df0 extends gf0 {
    public static /* synthetic */ Interceptable $ic;
    public static JSONObject h;
    public transient /* synthetic */ FieldHolder $fh;
    public ff0 c;
    public WeakReference<Context> d;
    public String e;
    public File f;
    public boolean g;

    /* loaded from: classes5.dex */
    public class a extends AsyncTask<Void, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ df0 a;

        public a(df0 df0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {df0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = df0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                if (df0.h == null) {
                    df0.h = new JSONObject();
                }
                if (this.a.f != null) {
                    if (this.a.g || !this.a.m()) {
                        if (!this.a.f.isDirectory()) {
                            try {
                                df0.h.put("file-del", true);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            this.a.f.delete();
                        }
                        File file = new File(this.a.f.getAbsoluteFile() + ".loading");
                        boolean a = this.a.c.a(this.a.e, file);
                        if (a) {
                            try {
                                df0.h.put("assetsToSD", true);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            a = file.renameTo(this.a.f);
                        }
                        if (!a) {
                            try {
                                df0.h.put("renameTo-del", true);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            hf0.b(file);
                            if (this.a.f.exists()) {
                                hf0.b(this.a.f);
                            }
                        }
                        try {
                            df0.h.put("result", a);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        if (this.a.l()) {
                            lf0.a("ARSourceCopyManager", "sdk exist + " + df0.h.toString());
                        }
                        return Boolean.valueOf(a);
                    }
                    try {
                        df0.h.put("exist", true);
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                    }
                    return Boolean.TRUE;
                }
                try {
                    df0.h.put("sdcardPath", StringUtil.NULL_STRING);
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                super.onPostExecute(bool);
                this.a.d(bool.booleanValue() ? 2 : 3);
            }
        }
    }

    public df0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            WeakReference<Context> weakReference = this.d;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.repackage.gf0
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean m = m();
            JSONObject jSONObject = new JSONObject();
            h = jSONObject;
            if (m) {
                try {
                    jSONObject.put("type", je0.a ? "assets" : "soloader");
                    h.put("exist", m);
                    h.put("path", this.f);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (l()) {
                    lf0.a("ARSourceCopyManager", "sdk exist + " + h.toString());
                }
                d(2);
            } else if (getContext() != null) {
                try {
                    if (l()) {
                        lf0.a("ARSourceCopyManager", "sdk loading .. to " + this.f.getAbsoluteFile());
                    }
                    k();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c = new ff0(getContext());
            new a(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ie0.m() : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            File file = this.f;
            return file != null && file.isDirectory() && this.f.exists();
        }
        return invokeV.booleanValue;
    }
}
