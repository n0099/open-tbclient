package com.repackage;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.publisher.PublishParams;
import com.baidu.swan.apps.publisher.draft.DraftData;
import com.baidu.swan.apps.publisher.emoji.EmojiEditText;
import com.baidu.swan.apps.publisher.view.PhotoChooseView;
import com.baidu.swan.apps.publisher.view.SPSwitchPanelLinearLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d02;
import com.repackage.qy2;
import com.repackage.ty2;
import com.repackage.yz2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class yx2 extends a02 implements View.OnClickListener, po2<MediaModel>, ty2.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a1;
    public transient /* synthetic */ FieldHolder $fh;
    public SPSwitchPanelLinearLayout F0;
    public EmojiEditText G0;
    public EmojiEditText H0;
    public TextView I0;
    public ImageView J0;
    public PhotoChooseView K0;
    public ImageView L0;
    public TextView M0;
    public TextView N0;
    public ImageView O0;
    public View P0;
    public PublishParams Q0;
    public boolean R0;
    public DraftData S0;
    public wx2 T0;
    public boolean U0;
    public int V0;
    public int W0;
    public int X0;
    public EmojiEditText.e Y0;
    public EmojiEditText.e Z0;

    /* loaded from: classes7.dex */
    public class a implements EmojiEditText.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx2 a;

        public a(yx2 yx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx2Var;
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.W0 = i;
                int i2 = i - 4999;
                this.a.M0.setVisibility(0);
                if (i2 < 999) {
                    this.a.M0.setText(String.format("超%d字", Integer.valueOf(i2)));
                } else {
                    this.a.M0.setText("超999+");
                }
                this.a.M0.setTextColor(SupportMenu.CATEGORY_MASK);
                this.a.o3();
            }
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a.W0 = i;
                if (i <= 4979) {
                    this.a.M0.setVisibility(8);
                } else {
                    this.a.M0.setText(String.format("剩%d字", Integer.valueOf(4999 - i)));
                    this.a.M0.setVisibility(0);
                    this.a.M0.setTextColor(this.a.X0);
                }
                this.a.o3();
            }
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void onBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx2 a;

        public b(yx2 yx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx2Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.u3();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx2 a;

        public c(yx2 yx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx2Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                ry2.onEvent("draft_save");
                this.a.S0.setTimeStamp(System.currentTimeMillis());
                this.a.S0.setTitle(this.a.G0.getText().toString());
                this.a.S0.setContent(this.a.H0.getText().toString());
                this.a.S0.setImages(this.a.v3());
                fy2.d(this.a.S0);
                this.a.p3();
                if (this.a.T0 != null) {
                    this.a.T0.onCancel();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx2 a;

        public d(yx2 yx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx2Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                ry2.onEvent("draft_quit");
                fy2.a();
                this.a.p3();
                if (this.a.T0 != null) {
                    this.a.T0.onCancel();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements qy2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx2 a;

        public e(yx2 yx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx2Var;
        }

        @Override // com.repackage.qy2.c
        public void onClickSwitch(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                this.a.m3(z);
                ry2.onEvent("emoji_clk");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx2 a;

        public f(yx2 yx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx2Var;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) && z) {
                this.a.q3();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx2 a;

        public g(yx2 yx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx2Var;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view2, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view2, i, keyEvent)) == null) {
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx2 a;

        public h(yx2 yx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx2Var;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) && z) {
                this.a.s3();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx2 a;

        public i(yx2 yx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx2Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.a.n3();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class j implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx2 a;

        public j(yx2 yx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx2Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                this.a.D3(view2, motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class k implements PhotoChooseView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx2 a;

        public k(yx2 yx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx2Var;
        }

        @Override // com.baidu.swan.apps.publisher.view.PhotoChooseView.b
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.a.o3();
                }
                if (i == this.a.Q0.getMaxImageNum() - 1) {
                    this.a.t3();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ViewGroup d;
        public final /* synthetic */ yx2 e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = lVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c03.d(this.a.d);
                }
            }
        }

        public l(yx2 yx2Var, List list, String str, String str2, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx2Var, list, str, str2, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = yx2Var;
            this.a = list;
            this.b = str;
            this.c = str2;
            this.d = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject a2 = py2.a(this.a, this.e.Q0.getImageRatio());
                    if (a2 == null) {
                        if (yx2.a1) {
                            Log.d("SwanAppPublisher", "图片解析失败");
                        }
                        a2 = new JSONObject();
                    }
                    if (!this.b.isEmpty()) {
                        a2.put("title", this.e.G0.getText().toString());
                    }
                    if (!this.c.isEmpty()) {
                        a2.put("content", this.e.H0.getText().toString());
                    }
                    if (yx2.a1) {
                        Log.d("SwanAppPublisher", "publish result " + a2.toString());
                    }
                    this.d.post(new a(this));
                    fy2.a();
                    this.e.T0.a(a2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements EmojiEditText.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx2 a;

        public m(yx2 yx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx2Var;
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.V0 = i;
                this.a.G0.setText(this.a.G0.getText().toString().substring(0, 20));
                this.a.G0.setSelection(20);
                vy2.h(this.a.getContext(), R.string.obfuscated_res_0x7f0f12e2);
                this.a.o3();
            }
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a.V0 = i;
                if (i == 0) {
                    this.a.O0.setVisibility(8);
                } else {
                    this.a.O0.setVisibility(0);
                }
                this.a.o3();
            }
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void onBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755126498, "Lcom/repackage/yx2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755126498, "Lcom/repackage/yx2;");
                return;
            }
        }
        a1 = eh1.a;
    }

    public yx2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.R0 = false;
        this.U0 = false;
        this.V0 = 0;
        this.W0 = 0;
        this.Y0 = new m(this);
        this.Z0 = new a(this);
    }

    public final boolean A3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String trim = this.Q0.supportTitle().booleanValue() ? this.G0.getText().toString().trim() : "";
            String trim2 = this.H0.getText().toString().trim();
            List<String> v3 = v3();
            if (TextUtils.isEmpty(trim) && TextUtils.isEmpty(trim2) && v3 == null) {
                fy2.a();
                return false;
            }
            if (TextUtils.equals(trim, this.S0.getTitle()) && TextUtils.equals(trim2, this.S0.getContent())) {
                List<String> images = this.S0.getImages();
                if (images == null && v3 == null) {
                    return false;
                }
                if (images != null && v3 != null && images.size() == v3.size()) {
                    for (int i2 = 0; i2 < v3.size(); i2++) {
                        if (!TextUtils.equals(images.get(i2), v3.get(i2))) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void B3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (A3()) {
                F3();
                return;
            }
            p3();
            wx2 wx2Var = this.T0;
            if (wx2Var != null) {
                wx2Var.onCancel();
            }
        }
    }

    public void C3(wx2 wx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wx2Var) == null) {
            this.T0 = wx2Var;
        }
    }

    public final void D3(View view2, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view2, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (view2 != null) {
                    view2.setAlpha(0.2f);
                }
            } else if (action != 2) {
                if (view2 != null) {
                    view2.setAlpha(1.0f);
                }
            } else if (view2 != null) {
                view2.setAlpha(0.2f);
            }
        }
    }

    public final void E3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            yz2.a aVar = new yz2.a(getContext());
            aVar.m(false);
            aVar.U(R.string.obfuscated_res_0x7f0f12d9);
            aVar.v(R.string.obfuscated_res_0x7f0f12dd);
            aVar.O(R.string.obfuscated_res_0x7f0f0112, new b(this));
            aVar.X();
        }
    }

    public final void F3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            yz2.a aVar = new yz2.a(getActivity());
            aVar.U(R.string.obfuscated_res_0x7f0f12ed);
            aVar.B(R.string.obfuscated_res_0x7f0f12ea, new d(this));
            aVar.v(R.string.obfuscated_res_0x7f0f12ec);
            aVar.O(R.string.obfuscated_res_0x7f0f12eb, new c(this));
            aVar.X();
        }
    }

    @Override // com.repackage.a02
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.U0) {
                if (a1) {
                    Log.d("SwanAppPublisher", "backPress: hide soft");
                }
                ty2.k(this.H0);
                this.U0 = false;
                return true;
            } else if (A3()) {
                if (a1) {
                    Log.d("SwanAppPublisher", "backPress: show draft dialog");
                }
                F3();
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void N0(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view2, bundle) == null) {
            super.N0(view2, bundle);
            if (this.R0) {
                E3();
                return;
            }
            z3(view2);
            if (this.Q0.supportEmoji().booleanValue() && !TextUtils.isEmpty(this.Q0.getEmojiPath().trim())) {
                y3();
            }
            x3();
            if (this.P0 == null) {
                this.P0 = this.Q0.supportTitle().booleanValue() ? this.G0 : this.H0;
            }
            ty2.n(this.P0, 300L);
            ry2.onEvent("show");
            o3();
        }
    }

    @Override // com.repackage.a02
    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.po2
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
        }
    }

    @Override // com.repackage.a02
    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.po2
    public void f(List<MediaModel> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (MediaModel mediaModel : list) {
                arrayList.add(mediaModel.getPath());
            }
            this.K0.update(arrayList);
            if (this.Q0.supportTitle().booleanValue() && this.V0 == 0 && this.W0 == 0) {
                ty2.n(this.G0, 300L);
            } else {
                ty2.n(this.H0, 300L);
            }
            o3();
            if (this.K0.getLeftCount() == 0) {
                r3();
            }
        }
    }

    @Override // com.repackage.a02
    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public final void m3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                this.J0.setImageResource(R.drawable.obfuscated_res_0x7f0811ac);
            } else {
                this.J0.setImageResource(R.drawable.obfuscated_res_0x7f0811af);
            }
        }
    }

    public final void n3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            qy2.d(this.F0, this.H0);
            ImageView imageView = this.J0;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f0811af);
            }
        }
    }

    public final void o3() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            List<String> v3 = v3();
            boolean z = !this.Q0.supportTitle().booleanValue() ? ((i2 = this.W0) <= 0 || i2 > 4999) && (v3 == null || v3.size() <= 0) : this.V0 <= 0 || (this.W0 <= 0 && (v3 == null || v3.size() <= 0));
            if (z && !this.N0.isClickable()) {
                this.N0.setClickable(true);
                this.N0.setTextColor(this.Q0.getPublishTextColor());
            } else if (z || !this.N0.isClickable()) {
            } else {
                this.N0.setClickable(false);
                this.N0.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a99));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091999) {
                ry2.onEvent("pub_clk");
                w3();
            } else if (id == R.id.obfuscated_res_0x7f090492) {
                ry2.onEvent("cancel_clk");
                B3();
            } else if (id == R.id.obfuscated_res_0x7f090118) {
                ry2.onEvent("pic_clk_bar");
                vy2.i(this.K0.getLeftCount(), this);
            } else if (id == R.id.obfuscated_res_0x7f090656) {
                this.G0.setText("");
            }
        }
    }

    @Override // com.repackage.ty2.b
    public void onSoftInputShowing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (a1) {
                Log.d("SwanAppPublisher", "soft input is showing ? " + z);
            }
            this.U0 = z;
        }
    }

    public void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ty2.k(this.H0);
            this.H0.e();
            this.G0.e();
            u3();
        }
    }

    public final void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.J0.setImageResource(R.drawable.obfuscated_res_0x7f0811ae);
            this.J0.setClickable(false);
        }
    }

    public final void r3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.L0.setImageResource(R.drawable.obfuscated_res_0x7f0811a8);
            this.L0.setClickable(false);
        }
    }

    public final void s3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.J0.setImageResource(R.drawable.obfuscated_res_0x7f0811af);
            this.J0.setClickable(true);
        }
    }

    public final void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.L0.setImageResource(R.drawable.obfuscated_res_0x7f081193);
            this.L0.setClickable(true);
        }
    }

    public final void u3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            d02.b i2 = hm2.U().V().i("navigateBack");
            i2.n(d02.i, d02.h);
            i2.g();
            i2.a();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void v0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            super.v0(bundle);
            Bundle q = q();
            if (q != null) {
                PublishParams publishParams = (PublishParams) q.getParcelable("params");
                this.Q0 = publishParams;
                if (publishParams == null) {
                    this.R0 = true;
                    return;
                }
                return;
            }
            this.R0 = true;
        }
    }

    public final List<String> v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.Q0.supportImage().booleanValue()) {
                return this.K0.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public final void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (a1) {
                Log.d("SwanAppPublisher", "go publish");
            }
            if (!SwanAppNetworkUtils.i(getContext())) {
                vy2.h(getContext(), R.string.obfuscated_res_0x7f0f12db);
            } else if (this.T0 == null) {
            } else {
                String obj = this.G0.getText().toString();
                String obj2 = this.H0.getText().toString();
                List<String> v3 = v3();
                if (this.Q0.supportTitle().booleanValue() && TextUtils.isEmpty(obj.trim())) {
                    vy2.h(getContext(), R.string.obfuscated_res_0x7f0f12d8);
                } else if (TextUtils.isEmpty(obj2.trim()) && (v3 == null || v3.size() == 0)) {
                    vy2.h(getContext(), R.string.obfuscated_res_0x7f0f12d8);
                } else if (v3 != null && v3.size() > 0) {
                    ViewGroup viewGroup = (ViewGroup) getActivity().findViewById(16908290);
                    c03.h(getContext(), viewGroup, getResources().getString(R.string.obfuscated_res_0x7f0f12da));
                    this.N0.setClickable(false);
                    this.N0.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060a99));
                    od3.f().execute(new l(this, v3, obj, obj2, viewGroup));
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (!obj.isEmpty()) {
                            jSONObject.put("title", this.G0.getText().toString());
                        }
                        if (!obj2.isEmpty()) {
                            jSONObject.put("content", this.H0.getText().toString());
                        }
                        if (a1) {
                            Log.d("SwanAppPublisher", "publish result " + jSONObject.toString());
                        }
                        fy2.a();
                        this.T0.a(jSONObject);
                    } catch (JSONException e2) {
                        if (a1) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public final void x3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            DraftData c2 = fy2.c();
            this.S0 = c2;
            if (c2 != null) {
                if (a1) {
                    Log.d("SwanAppPublisher", "update view from draft data");
                }
                String title = this.S0.getTitle();
                if (this.Q0.supportTitle().booleanValue() && !TextUtils.isEmpty(title)) {
                    this.G0.setText(title);
                    this.G0.setSelection(title.length());
                    this.P0 = this.G0;
                }
                String content = this.S0.getContent();
                if (!TextUtils.isEmpty(content)) {
                    this.H0.setText(content);
                    if (this.Q0.supportEmoji().booleanValue() && hy2.c().e()) {
                        this.H0.c();
                    }
                    EmojiEditText emojiEditText = this.H0;
                    emojiEditText.setSelection(emojiEditText.getText().length());
                    this.P0 = this.H0;
                }
                if (this.Q0.supportImage().booleanValue()) {
                    this.K0.update(this.S0.getImages());
                    if (this.K0.getLeftCount() == 0) {
                        r3();
                        return;
                    }
                    return;
                }
                return;
            }
            this.S0 = new DraftData(0L, "", "", null);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048604, this, layoutInflater, viewGroup, bundle)) == null) {
            super.y0(layoutInflater, viewGroup, bundle);
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d07cf, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    public final void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            ty2.c(getActivity(), (ViewGroup) getActivity().findViewById(16908290), this.F0, this);
            qy2.b(this.F0, this.J0, this.H0, new e(this));
            jy2.b().c(getActivity(), this.F0, this.H0, this.Q0.getEmojiPath(), this.Q0.getAppId(), this.Q0.getAppVersion());
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void z3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, view2) == null) {
            if (a1) {
                Log.d("SwanAppPublisher", "init view");
            }
            this.G0 = (EmojiEditText) view2.findViewById(R.id.obfuscated_res_0x7f09191a);
            if (this.Q0.supportTitle().booleanValue()) {
                view2.findViewById(R.id.obfuscated_res_0x7f09191b).setVisibility(0);
                this.G0.setHint(this.Q0.getTitleHint());
                this.G0.setListener(this.Y0);
                this.G0.setMaxSize(20);
                this.G0.setOnFocusChangeListener(new f(this));
            } else {
                view2.findViewById(R.id.obfuscated_res_0x7f09191b).setVisibility(8);
            }
            this.J0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090101);
            if (this.Q0.supportEmoji().booleanValue() && !TextUtils.isEmpty(this.Q0.getEmojiPath().trim())) {
                this.J0.setVisibility(0);
            } else {
                this.J0.setVisibility(8);
            }
            this.F0 = (SPSwitchPanelLinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09086a);
            view2.findViewById(R.id.obfuscated_res_0x7f09150e).setBackgroundColor(this.Q0.getNavBarBgColor());
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919a7);
            textView.setText(this.Q0.getNavBarTitle());
            textView.setTextColor(this.Q0.getNavBarTextColor());
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090656);
            this.O0 = imageView;
            imageView.setOnClickListener(this);
            this.I0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091916);
            if (this.Q0.supportTarget().booleanValue() && !TextUtils.isEmpty(this.Q0.getTarget().trim())) {
                TextView textView2 = this.I0;
                textView2.setText("发布到 " + this.Q0.getTarget());
            } else {
                view2.findViewById(R.id.obfuscated_res_0x7f091917).setVisibility(8);
            }
            this.M0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f88);
            EmojiEditText emojiEditText = (EmojiEditText) view2.findViewById(R.id.obfuscated_res_0x7f0918f8);
            this.H0 = emojiEditText;
            emojiEditText.setOnKeyListener(new g(this));
            this.H0.setHint(this.Q0.getContentHint());
            this.H0.setListener(this.Z0);
            this.H0.setMaxSize(4999);
            this.H0.setOnFocusChangeListener(new h(this));
            view2.findViewById(R.id.obfuscated_res_0x7f0906e9).setOnTouchListener(new i(this));
            TextView textView3 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091999);
            this.N0 = textView3;
            textView3.setText(this.Q0.getPublishText());
            this.N0.setOnClickListener(this);
            this.N0.setClickable(false);
            TextView textView4 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090492);
            textView4.setText(this.Q0.getCancelText());
            textView4.setTextColor(this.Q0.getCancelTextColor());
            textView4.setOnClickListener(this);
            textView4.setOnTouchListener(new j(this));
            this.L0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090118);
            this.K0 = (PhotoChooseView) view2.findViewById(R.id.obfuscated_res_0x7f091886);
            if (this.Q0.supportImage().booleanValue()) {
                this.L0.setVisibility(0);
                this.L0.setOnClickListener(this);
                this.K0.setVisibility(0);
                this.K0.d(getActivity());
                this.K0.setMaxCount(this.Q0.getMaxImageNum());
                this.K0.setCallback(this);
                this.K0.setDeleteListener(new k(this));
            } else {
                this.L0.setVisibility(8);
                this.K0.setVisibility(8);
            }
            this.X0 = getResources().getColor(R.color.obfuscated_res_0x7f060a98);
        }
    }
}
