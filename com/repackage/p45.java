package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class p45 {
    public static /* synthetic */ Interceptable $ic;
    public static p45 g;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public HashMap<Integer, View> c;
    public FragmentTabWidget d;
    public boolean e;
    public boolean f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755459872, "Lcom/repackage/p45;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755459872, "Lcom/repackage/p45;");
        }
    }

    public p45() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new HashMap<>();
        this.e = false;
        this.f = false;
        this.e = UbsABTestHelper.isPreShowPersonViewA();
    }

    public static p45 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (g == null) {
                synchronized (p45.class) {
                    if (g == null) {
                        g = new p45();
                    }
                }
            }
            return g;
        }
        return (p45) invokeV.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.e && SpeedStats.getInstance().isStartAppFromLauncher() : invokeV.booleanValue;
    }

    public FragmentTabWidget b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (this.d == null) {
                this.d = new FragmentTabWidget(context);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.height = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
                layoutParams.gravity = 80;
                this.d.setLayoutParams(layoutParams);
                this.d.setClipChildren(false);
                this.d.setClipToPadding(false);
                this.d.setOrientation(0);
                this.d.setShouldDrawIndicatorLine(false);
                this.d.setShouldDrawTopLine(false);
                this.d.setBackGroundStyle(0);
            }
            FragmentTabWidget fragmentTabWidget = this.d;
            if (fragmentTabWidget != null && (fragmentTabWidget.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.d.getParent()).removeView(this.d);
            }
            return this.d;
        }
        return (FragmentTabWidget) invokeL.objValue;
    }

    public View c(Context context) {
        InterceptResult invokeL;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (this.b == null && (runTask = MessageManager.getInstance().runTask(2921672, View.class, context)) != null) {
                this.b = (View) runTask.getData();
            }
            View view2 = this.b;
            if (view2 != null && (view2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.b.getParent()).removeView(this.b);
            }
            return this.b;
        }
        return (View) invokeL.objValue;
    }

    public View d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            View view2 = this.c.get(Integer.valueOf(i));
            if (view2 != null && (view2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            this.c.remove(Integer.valueOf(i));
            return view2;
        }
        return (View) invokeI.objValue;
    }

    public View f(Context context) {
        InterceptResult invokeL;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            if (this.a == null && (runTask = MessageManager.getInstance().runTask(2921671, View.class, context)) != null) {
                this.a = (View) runTask.getData();
            }
            View view2 = this.a;
            if (view2 != null && (view2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.a.getParent()).removeView(this.a);
            }
            return this.a;
        }
        return (View) invokeL.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f : invokeV.booleanValue;
    }
}
