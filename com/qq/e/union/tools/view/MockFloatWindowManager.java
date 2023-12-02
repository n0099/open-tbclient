package com.qq.e.union.tools.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.union.tools.ToolsActivity;
import com.qq.e.union.tools.view.MockFloatWindowManager;
/* loaded from: classes10.dex */
public class MockFloatWindowManager {
    public static /* synthetic */ Interceptable $ic;
    public static volatile MockFloatWindowManager g;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean a;
    public WindowManager b;
    public WindowManager.LayoutParams c;
    public TextView d;
    public Context e;
    public LinearLayout f;

    public MockFloatWindowManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view2) {
        Intent intent = new Intent(this.e, ToolsActivity.class);
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        this.e.startActivity(intent);
    }

    public static MockFloatWindowManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (g == null) {
                synchronized (MockFloatWindowManager.class) {
                    if (g == null) {
                        g = new MockFloatWindowManager();
                    }
                }
            }
            return g;
        }
        return (MockFloatWindowManager) invokeV.objValue;
    }

    public void changeState(boolean z) {
        TextView textView;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                textView = this.d;
                str = "联\n调\n中";
            } else {
                textView = this.d;
                str = "广\n告\n助\n手";
            }
            textView.setText(str);
        }
    }

    public int dp2Px(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? ((int) this.e.getResources().getDisplayMetrics().density) * i : invokeI.intValue;
    }

    public void needHide(boolean z) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (linearLayout = this.f) == null) {
            return;
        }
        linearLayout.setVisibility(z ? 8 : 0);
    }

    public void remove() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a) {
            this.a = false;
            this.b.removeView(this.f);
        }
    }

    /* loaded from: classes10.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public final /* synthetic */ MockFloatWindowManager c;

        public a(MockFloatWindowManager mockFloatWindowManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mockFloatWindowManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mockFloatWindowManager;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 2) {
                        int rawX = (int) motionEvent.getRawX();
                        int rawY = (int) motionEvent.getRawY();
                        int i = rawX - this.a;
                        int i2 = rawY - this.b;
                        this.a = rawX;
                        this.b = rawY;
                        MockFloatWindowManager mockFloatWindowManager = this.c;
                        WindowManager.LayoutParams layoutParams = mockFloatWindowManager.c;
                        layoutParams.x -= i;
                        layoutParams.y -= i2;
                        mockFloatWindowManager.b.updateViewLayout(view2, layoutParams);
                        return false;
                    }
                    return false;
                }
                this.a = (int) motionEvent.getRawX();
                this.b = (int) motionEvent.getRawY();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public final void a() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SharedPreferences sharedPreferences = this.e.getSharedPreferences("gdt_mock.xml", 0);
            TextView textView = new TextView(this.e);
            this.d = textView;
            textView.setGravity(17);
            this.d.setTextColor(-1);
            if (sharedPreferences.getInt("crtSize", -1) != -1 && sharedPreferences.getInt("productType", -1) != -1) {
                changeState(true);
            } else {
                changeState(false);
            }
            LinearLayout linearLayout = new LinearLayout(this.e);
            this.f = linearLayout;
            linearLayout.setOnTouchListener(new a(this));
            this.f.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.uec
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        MockFloatWindowManager.this.a(view2);
                    }
                }
            });
            ImageView imageView = new ImageView(this.e);
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080fc4);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(10, 0, 10, 0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(70, 60);
            this.f.setOrientation(1);
            this.f.setGravity(17);
            this.f.setBackgroundResource(R.drawable.shape_corner);
            this.f.addView(imageView, layoutParams);
            this.f.addView(this.d);
            this.b = (WindowManager) this.e.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
            WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
            this.c = layoutParams2;
            if (Build.VERSION.SDK_INT >= 26) {
                i = 2038;
            } else {
                i = 2002;
            }
            layoutParams2.type = i;
            WindowManager.LayoutParams layoutParams3 = this.c;
            layoutParams3.gravity = 85;
            layoutParams3.format = -2;
            layoutParams3.x = dp2Px(3);
            this.c.y = dp2Px(130);
            WindowManager.LayoutParams layoutParams4 = this.c;
            layoutParams4.flags = 40;
            layoutParams4.width = 80;
            layoutParams4.height = 290;
        }
    }

    public void show(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, context) != null) || this.a) {
            return;
        }
        this.e = context;
        a();
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this.e)) {
            Toast.makeText(this.e, "无悬浮窗权限，请授权！", 0).show();
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + this.e.getPackageName()));
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            this.e.startActivity(intent);
        } else {
            z = true;
        }
        if (z) {
            this.a = true;
            this.b.addView(this.f, this.c);
        }
    }
}
