package com.repackage;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dr4;
/* loaded from: classes6.dex */
public class oc8 extends dr4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public EditText b;

    /* loaded from: classes6.dex */
    public class a implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ oc8 b;

        public a(oc8 oc8Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc8Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oc8Var;
            this.a = activity;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                if (!oi.isEmpty(this.b.b.getText().toString())) {
                    TbSingleton.getInstance().setVisitPreviewServer(true);
                    String obj = this.b.b.getText().toString();
                    TbSingleton.getInstance().setPubEnvValue(obj);
                    pi.N(this.a, R.string.obfuscated_res_0x7f0f038f);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921508, obj));
                }
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc8 a;

        public b(oc8 oc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc8Var;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oc8(Activity activity) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.obfuscated_res_0x7f0d022e, (ViewGroup) null);
        this.a = linearLayout;
        setContentView(linearLayout);
        this.b = (EditText) this.a.findViewById(R.id.obfuscated_res_0x7f0908e8);
        setPositiveButton(R.string.obfuscated_res_0x7f0f0426, new a(this, activity));
        setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new b(this));
    }
}
