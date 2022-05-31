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
public class nw2 {
    public static /* synthetic */ Interceptable $ic;
    public static nw2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public WeakReference<mw2> b;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<hz2> a;
        public WeakReference<py1> b;
        public String c;
        public MediaModel d;

        public b(nw2 nw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(nw2 nw2Var, a aVar) {
            this(nw2Var);
        }
    }

    public nw2() {
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

    public static nw2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (nw2.class) {
                    if (c == null) {
                        c = new nw2();
                    }
                }
            }
            return c;
        }
        return (nw2) invokeV.objValue;
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
            mw2 mw2Var = this.b.get();
            if (mw2Var != null) {
                mw2Var.B1();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d(String str, MediaModel mediaModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, mediaModel) == null) {
            hz2 L = hz2.L();
            py1 H = uk2.U().H();
            if (L != null && H != null) {
                b bVar = new b(this, null);
                this.a = bVar;
                bVar.a = new WeakReference<>(L);
                this.a.b = new WeakReference<>(H);
                b bVar2 = this.a;
                bVar2.c = str;
                bVar2.d = mediaModel;
                return;
            }
            this.a = null;
        }
    }

    public void e(hz2 hz2Var, ReplyEditorParams replyEditorParams, jw2 jw2Var) {
        py1 H;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, hz2Var, replyEditorParams, jw2Var) == null) || (H = uk2.U().H()) == null || hz2Var == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", replyEditorParams);
        b bVar = this.a;
        if (bVar != null && hz2Var == bVar.a.get() && H == this.a.b.get()) {
            bundle.putBoolean(MediaTrackConfig.AE_IMPORT_DRAFT, true);
            bundle.putString("content", this.a.c);
            bundle.putParcelable("image", this.a.d);
        }
        mw2 mw2Var = new mw2();
        mw2Var.i1(bundle);
        mw2Var.O1(jw2Var);
        mw2Var.s1(H.v(), "ReplyEditor");
        this.b = new WeakReference<>(mw2Var);
    }
}
