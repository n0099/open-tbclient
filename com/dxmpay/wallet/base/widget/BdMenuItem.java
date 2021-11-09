package com.dxmpay.wallet.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class BdMenuItem {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f62348a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f62349b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62350c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f62351d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f62352e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f62353f;

    /* renamed from: g  reason: collision with root package name */
    public int f62354g;

    /* renamed from: h  reason: collision with root package name */
    public String f62355h;

    /* renamed from: i  reason: collision with root package name */
    public OnItemClickListener f62356i;
    public Context j;
    public BdMenu k;

    /* loaded from: classes11.dex */
    public interface OnItemClickListener {
        void onClick(BdMenuItem bdMenuItem);
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), charSequence};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62349b = true;
        this.f62350c = false;
        this.f62351d = false;
        this.f62354g = 0;
        this.j = context;
        this.f62348a = i2;
        this.f62352e = charSequence;
    }

    public Drawable getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Drawable drawable = this.f62353f;
            if (drawable != null) {
                return drawable;
            }
            if (this.f62354g != 0) {
                Drawable drawable2 = this.j.getResources().getDrawable(this.f62354g);
                this.f62354g = 0;
                this.f62353f = drawable2;
                return drawable2;
            }
            return null;
        }
        return (Drawable) invokeV.objValue;
    }

    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f62355h : (String) invokeV.objValue;
    }

    public int getItemId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f62348a : invokeV.intValue;
    }

    public BdMenu getMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (BdMenu) invokeV.objValue;
    }

    public OnItemClickListener getOnClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f62356i : (OnItemClickListener) invokeV.objValue;
    }

    public CharSequence getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f62352e : (CharSequence) invokeV.objValue;
    }

    public boolean isChecked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f62350c : invokeV.booleanValue;
    }

    public boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f62349b : invokeV.booleanValue;
    }

    public void setChecked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f62350c = z;
        }
    }

    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f62349b = z;
        }
    }

    public BdMenuItem setIcon(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, drawable)) == null) {
            this.f62354g = 0;
            this.f62353f = drawable;
            return this;
        }
        return (BdMenuItem) invokeL.objValue;
    }

    public BdMenuItem setIconUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.f62354g = 0;
            this.f62355h = str;
            return this;
        }
        return (BdMenuItem) invokeL.objValue;
    }

    public void setMenu(BdMenu bdMenu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bdMenu) == null) {
            this.k = bdMenu;
        }
    }

    public void setOnClickListener(OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onItemClickListener) == null) {
            this.f62356i = onItemClickListener;
        }
    }

    public void setShowTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f62351d = z;
        }
    }

    public BdMenuItem setTitle(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, charSequence)) == null) {
            this.f62352e = charSequence;
            return this;
        }
        return (BdMenuItem) invokeL.objValue;
    }

    public boolean showTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f62351d : invokeV.booleanValue;
    }

    public BdMenuItem setTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            this.f62352e = this.j.getResources().getText(i2, this.f62352e);
            return this;
        }
        return (BdMenuItem) invokeI.objValue;
    }

    public BdMenuItem setIcon(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            this.f62353f = null;
            this.f62354g = i2;
            return this;
        }
        return (BdMenuItem) invokeI.objValue;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), charSequence, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f62349b = true;
        this.f62350c = false;
        this.f62351d = false;
        this.f62354g = 0;
        this.j = context;
        this.f62348a = i2;
        this.f62352e = charSequence;
        this.f62354g = i3;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), charSequence, drawable};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f62349b = true;
        this.f62350c = false;
        this.f62351d = false;
        this.f62354g = 0;
        this.j = context;
        this.f62348a = i2;
        this.f62352e = charSequence;
        this.f62353f = drawable;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), charSequence, str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f62349b = true;
        this.f62350c = false;
        this.f62351d = false;
        this.f62354g = 0;
        this.j = context;
        this.f62348a = i2;
        this.f62352e = charSequence;
        this.f62355h = str;
    }
}
