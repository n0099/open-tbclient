package com.repackage;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.publisher.ReplyEditorParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class nx2 {
    public static /* synthetic */ Interceptable $ic;
    public static nx2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public WeakReference<mx2> b;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<h03> a;
        public WeakReference<pz1> b;
        public String c;
        public MediaModel d;

        public b(nx2 nx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(nx2 nx2Var, a aVar) {
            this(nx2Var);
        }
    }

    public nx2() {
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

    public static nx2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (nx2.class) {
                    if (c == null) {
                        c = new nx2();
                    }
                }
            }
            return c;
        }
        return (nx2) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = null;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            mx2 mx2Var = this.b.get();
            if (mx2Var != null) {
                mx2Var.C1();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d(String str, MediaModel mediaModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, mediaModel) == null) {
            h03 M = h03.M();
            pz1 H = ul2.U().H();
            if (M != null && H != null) {
                b bVar = new b(this, null);
                this.a = bVar;
                bVar.a = new WeakReference<>(M);
                this.a.b = new WeakReference<>(H);
                b bVar2 = this.a;
                bVar2.c = str;
                bVar2.d = mediaModel;
                return;
            }
            this.a = null;
        }
    }

    public void e(h03 h03Var, ReplyEditorParams replyEditorParams, jx2 jx2Var) {
        pz1 H;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, h03Var, replyEditorParams, jx2Var) == null) || (H = ul2.U().H()) == null || h03Var == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", replyEditorParams);
        b bVar = this.a;
        if (bVar != null && h03Var == bVar.a.get() && H == this.a.b.get()) {
            bundle.putBoolean(MediaTrackConfig.AE_IMPORT_DRAFT, true);
            bundle.putString("content", this.a.c);
            bundle.putParcelable("image", this.a.d);
        }
        mx2 mx2Var = new mx2();
        mx2Var.j1(bundle);
        mx2Var.P1(jx2Var);
        mx2Var.t1(H.v(), "ReplyEditor");
        this.b = new WeakReference<>(mx2Var);
    }
}
