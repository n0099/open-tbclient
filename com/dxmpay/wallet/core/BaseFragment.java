package com.dxmpay.wallet.core;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.core.FragmentResultReceiver;
import com.dxmpay.wallet.core.utils.FragmentUtils;
/* loaded from: classes3.dex */
public class BaseFragment extends SDKBaseFragment implements FragmentResultReceiver.a, NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String EXTRA_FRAGMENT_RESULT_RECEIVER = "fragment result receiver";
    public static final String EXTRA_REQUEST_CODE = "request code";
    public static final String EXTRA_RESULT_CODE = "result code";
    public static final int MSG_RESPONSE_FAILURE = 2;
    public static final int MSG_RESPONSE_SUCCESS = 1;
    public static final String TAG_BASE = "BaseFragment";
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity mAct;
    public boolean mDestroyAct;
    public ResultReceiver mReceiver;
    public int mRequestId;

    public BaseFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mReceiver = null;
        this.mRequestId = -1;
        this.mDestroyAct = true;
    }

    public static String getClassFileLineMethod(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            StackTraceElement stackTraceElement = new Exception().getStackTrace()[1];
            StringBuilder sb = new StringBuilder();
            if (str != null && str.length() > 0) {
                sb.append(str);
                sb.append(": ");
            }
            sb.append(PreferencesUtil.LEFT_MOUNT);
            sb.append(stackTraceElement.getFileName());
            sb.append(" | ");
            sb.append(stackTraceElement.getLineNumber());
            sb.append(" | ");
            sb.append(stackTraceElement.getMethodName());
            sb.append("()");
            sb.append(PreferencesUtil.RIGHT_MOUNT);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void logFragmentStack(FragmentManager fragmentManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, fragmentManager) == null) {
        }
    }

    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            finish(this.mDestroyAct);
        }
    }

    public boolean getDestroyActFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDestroyAct : invokeV.booleanValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            Bundle arguments = getArguments();
            if (arguments != null && arguments.containsKey("fragment result receiver") && arguments.containsKey("request code")) {
                this.mReceiver = (ResultReceiver) getArguments().getParcelable("fragment result receiver");
                this.mRequestId = getArguments().getInt("request code");
            }
            return onCreateView;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ResultReceiver resultReceiver = this.mReceiver;
            if (resultReceiver != null && (resultReceiver instanceof FragmentResultReceiver)) {
                ((FragmentResultReceiver) resultReceiver).a();
            }
            super.onDestroyView();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mAct = null;
            super.onDetach();
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, keyEvent)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, keyEvent)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPause();
        }
    }

    @Override // com.dxmpay.wallet.core.FragmentResultReceiver.a
    public void onReceiveResult(int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, bundle) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048588, this, i2, strArr, iArr) == null) {
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onResume();
        }
    }

    public void popBackFragment(int i2, boolean z) {
        BaseActivity baseActivity;
        FragmentManager supportFragmentManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (baseActivity = this.mAct) == null || baseActivity.getActivity() == null || (supportFragmentManager = ((FragmentActivity) this.mAct.getActivity()).getSupportFragmentManager()) == null) {
            return;
        }
        logFragmentStack(supportFragmentManager);
        while (i2 > 0 && this.mAct != null) {
            if (!FragmentUtils.popBackStackImmediate(supportFragmentManager)) {
                if (z) {
                    this.mAct.finish();
                    return;
                }
                return;
            }
            i2--;
        }
    }

    @Override // com.dxmpay.wallet.core.SDKBaseFragment
    public void setActivity(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, baseActivity) == null) {
            this.mAct = baseActivity;
        }
    }

    public void setResult(Bundle bundle) {
        ResultReceiver resultReceiver;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) || (resultReceiver = this.mReceiver) == null) {
            return;
        }
        resultReceiver.send(this.mRequestId, bundle);
    }

    public void setUnDestroyActFlag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.mDestroyAct = false;
        }
    }

    public void finish(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            popBackFragment(1, z);
        }
    }
}
