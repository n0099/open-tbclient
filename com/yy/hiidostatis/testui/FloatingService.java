package com.yy.hiidostatis.testui;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.UiThreadExecutor;
import java.util.ArrayList;
import java.util.List;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class FloatingService {
    public static final /* synthetic */ FloatingService[] $VALUES;
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_BG = 1879048192;
    public static final FloatingService INSTANCT;
    public static final int MOVING_BG = 1895611159;
    public transient /* synthetic */ FieldHolder $fh;
    public LogAdapter adapter;
    public Context app;
    public String filterAppkey;
    public volatile boolean init;
    public boolean isDebug;
    public WindowManager.LayoutParams layoutParams;
    public ListView listView;
    public List<String> logs;
    public boolean movingState;
    public WindowManager windowManager;

    /* loaded from: classes8.dex */
    public class FloatingOnTouchListener implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long downTime;
        public boolean hasDown;
        public final /* synthetic */ FloatingService this$0;
        public int x;
        public int y;

        public FloatingOnTouchListener(FloatingService floatingService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {floatingService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = floatingService;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action != 2 || !this.hasDown) {
                            return true;
                        }
                        if (this.this$0.movingState) {
                            int rawX = (int) motionEvent.getRawX();
                            int rawY = (int) motionEvent.getRawY();
                            int i = rawX - this.x;
                            int i2 = rawY - this.y;
                            this.x = rawX;
                            this.y = rawY;
                            this.this$0.layoutParams.x += i;
                            this.this$0.layoutParams.y += i2;
                            this.this$0.windowManager.updateViewLayout(view2, this.this$0.layoutParams);
                        } else if (System.currentTimeMillis() - this.downTime > 1500) {
                            this.this$0.movingState = true;
                            this.this$0.listView.setBackgroundColor(FloatingService.MOVING_BG);
                        }
                    } else if (!this.hasDown) {
                        return true;
                    } else {
                        this.hasDown = false;
                        if (this.this$0.movingState) {
                            this.this$0.movingState = false;
                            this.this$0.listView.setBackgroundColor(FloatingService.DEFAULT_BG);
                        }
                    }
                } else {
                    this.x = (int) motionEvent.getRawX();
                    this.y = (int) motionEvent.getRawY();
                    int[] iArr = new int[2];
                    this.this$0.listView.getLocationOnScreen(iArr);
                    int i3 = iArr[0];
                    int i4 = this.x;
                    if (i3 < i4 && i4 < iArr[0] + this.this$0.listView.getWidth()) {
                        int i5 = iArr[1];
                        int i6 = this.y;
                        if (i5 < i6 && i6 < iArr[1] + this.this$0.listView.getHeight()) {
                            this.hasDown = true;
                            this.downTime = System.currentTimeMillis();
                        }
                    }
                    this.hasDown = false;
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class LogAdapter extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FloatingService this$0;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? i : invokeI.longValue;
        }

        public LogAdapter(FloatingService floatingService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {floatingService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = floatingService;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return this.this$0.logs.get(i);
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.this$0.logs.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            TextView textView;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    LinearLayout linearLayout2 = new LinearLayout(viewGroup.getContext());
                    linearLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                    linearLayout2.setDividerPadding(0);
                    textView = new TextView(viewGroup.getContext());
                    textView.setTag("log");
                    textView.setTextColor(-1);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    textView.setLayoutParams(layoutParams);
                    linearLayout2.addView(textView, layoutParams);
                    linearLayout = linearLayout2;
                } else {
                    textView = (TextView) view2.findViewWithTag("log");
                    linearLayout = view2;
                }
                textView.setText((CharSequence) this.this$0.logs.get(i));
                return linearLayout;
            }
            return (View) invokeILL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(217616162, "Lcom/yy/hiidostatis/testui/FloatingService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(217616162, "Lcom/yy/hiidostatis/testui/FloatingService;");
                return;
            }
        }
        FloatingService floatingService = new FloatingService("INSTANCT", 0);
        INSTANCT = floatingService;
        $VALUES = new FloatingService[]{floatingService};
    }

    public static FloatingService[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return (FloatingService[]) $VALUES.clone();
        }
        return (FloatingService[]) invokeV.objValue;
    }

    public String getFilterAppkey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.filterAppkey;
        }
        return (String) invokeV.objValue;
    }

    public boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.isDebug;
        }
        return invokeV.booleanValue;
    }

    public boolean isInit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.init;
        }
        return invokeV.booleanValue;
    }

    public FloatingService(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.layoutParams = new WindowManager.LayoutParams();
        this.logs = new ArrayList();
        this.adapter = new LogAdapter(this);
        this.init = false;
    }

    public static FloatingService valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            return (FloatingService) Enum.valueOf(FloatingService.class, str);
        }
        return (FloatingService) invokeL.objValue;
    }

    public void setDebug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.isDebug = z;
        }
    }

    public void setFilterAppkey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.filterAppkey = str;
        }
    }

    public void showFloatingWindow(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
            this.isDebug = true;
            Application application = activity.getApplication();
            this.app = application;
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(application)) {
                    initView();
                    return;
                }
                return;
            }
            initView();
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.windowManager = (WindowManager) this.app.getSystemService("window");
            ListView listView = new ListView(this.app);
            listView.setAdapter((ListAdapter) this.adapter);
            listView.setBackgroundColor(DEFAULT_BG);
            listView.setPadding(10, 10, 10, 10);
            this.listView = listView;
            if (Build.VERSION.SDK_INT >= 26) {
                this.layoutParams.type = 2038;
            } else {
                this.layoutParams.type = 2002;
            }
            WindowManager.LayoutParams layoutParams = this.layoutParams;
            layoutParams.format = 1;
            layoutParams.width = -1;
            layoutParams.height = 300;
            layoutParams.x = 0;
            layoutParams.y = 10;
            layoutParams.flags = 40;
            layoutParams.gravity = 51;
            listView.setOnTouchListener(new FloatingOnTouchListener());
            this.windowManager.addView(listView, this.layoutParams);
            this.init = true;
        }
    }

    public void addLog(String str, String str2, String str3, String str4, String str5) {
        String format;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(1048576, this, str, str2, str3, str4, str5) != null) || !this.isDebug) {
            return;
        }
        String str6 = this.filterAppkey;
        if (str6 != null && !str6.isEmpty()) {
            if (!this.filterAppkey.startsWith(str2)) {
                return;
            }
            format = String.format("%s  %s  %s  %s", str, str3, str5, str4);
        } else {
            format = String.format("%s %s %s %s %s", str, str3, str5, str4, str2);
        }
        UiThreadExecutor.runTask(new Runnable(this, format) { // from class: com.yy.hiidostatis.testui.FloatingService.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FloatingService this$0;
            public final /* synthetic */ String val$log;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, format};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$log = format;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.this$0.logs.size() >= 499) {
                        this.this$0.logs.remove(0);
                    }
                    this.this$0.logs.add(this.val$log);
                    if (this.this$0.init) {
                        this.this$0.adapter.notifyDataSetChanged();
                        this.this$0.listView.smoothScrollToPosition(this.this$0.logs.size());
                    }
                }
            }
        });
    }
}
