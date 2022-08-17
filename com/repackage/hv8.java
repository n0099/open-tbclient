package com.repackage;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.IdRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hv8 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: e */
    public static final int obfuscated = 2131232810;

    /* renamed from: f */
    public static final int obfuscated = 2131232809;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public ImageView b;
    public b c;
    public CustomMessageListener d;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(hv8 hv8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hv8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.a.c != null) {
                    this.a.c.a(booleanValue);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755634681, "Lcom/repackage/hv8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755634681, "Lcom/repackage/hv8;");
        }
    }

    public hv8(View view2, @IdRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new a(this, 2921647);
        MessageManager.getInstance().registerListener(this.d);
        this.a = view2;
        if (view2 != null) {
            ImageView imageView = (ImageView) view2.findViewById(i);
            this.b = imageView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        }
        j(d());
    }

    public static StatisticItem b(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, str, str2, i)) == null) ? new StatisticItem(str).param("obj_locate", c(i)).param("tid", str2).param("uid", TbadkCoreApplication.getCurrentAccountId()) : (StatisticItem) invokeLLI.objValue;
    }

    public static String c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) ? (i == 4 || i == 3) ? "2" : "1" : (String) invokeI.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TbSingleton.getInstance().isDanmuSwitchOpen() : invokeV.booleanValue;
    }

    public void e(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
            TiebaStatic.log(b("c14474", str, i).param("obj_type", d() ? "1" : "0"));
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.d);
            ImageView imageView = this.b;
            if (imageView != null) {
                imageView.setOnClickListener(null);
            }
            this.c = null;
        }
    }

    public void g(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) || (imageView = this.b) == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.c = bVar;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            boolean z = !d();
            TbSingleton.getInstance().setDanmuSwitchOpen(z);
            j(z);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921647, Boolean.valueOf(z)));
        }
    }

    public void j(boolean z) {
        ImageView imageView;
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (imageView = this.b) == null || (view2 = this.a) == null) {
            return;
        }
        imageView.setImageDrawable(view2.getResources().getDrawable(z ? obfuscated : obfuscated));
    }
}
