package com.qq.e.ads.hybrid;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class HybridADSetting implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<HybridADSetting> CREATOR;
    public static final int TYPE_REWARD_VIDEO = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f59019b;

    /* renamed from: c  reason: collision with root package name */
    public int f59020c;

    /* renamed from: d  reason: collision with root package name */
    public int f59021d;

    /* renamed from: e  reason: collision with root package name */
    public int f59022e;

    /* renamed from: f  reason: collision with root package name */
    public String f59023f;

    /* renamed from: g  reason: collision with root package name */
    public String f59024g;

    /* renamed from: h  reason: collision with root package name */
    public String f59025h;

    /* renamed from: i  reason: collision with root package name */
    public int f59026i;

    /* renamed from: j  reason: collision with root package name */
    public int f59027j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-469252513, "Lcom/qq/e/ads/hybrid/HybridADSetting;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-469252513, "Lcom/qq/e/ads/hybrid/HybridADSetting;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<HybridADSetting>() { // from class: com.qq.e.ads.hybrid.HybridADSetting.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public HybridADSetting createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new HybridADSetting(parcel) : (HybridADSetting) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public HybridADSetting[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new HybridADSetting[i2] : (HybridADSetting[]) invokeI.objValue;
            }
        };
    }

    public HybridADSetting() {
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
        this.a = 1;
        this.f59019b = 44;
        this.f59020c = -1;
        this.f59021d = -14013133;
        this.f59022e = 16;
        this.f59026i = -1776153;
        this.f59027j = 16;
    }

    public HybridADSetting(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 1;
        this.f59019b = 44;
        this.f59020c = -1;
        this.f59021d = -14013133;
        this.f59022e = 16;
        this.f59026i = -1776153;
        this.f59027j = 16;
        this.a = parcel.readInt();
        this.f59019b = parcel.readInt();
        this.f59020c = parcel.readInt();
        this.f59021d = parcel.readInt();
        this.f59022e = parcel.readInt();
        this.f59023f = parcel.readString();
        this.f59024g = parcel.readString();
        this.f59025h = parcel.readString();
        this.f59026i = parcel.readInt();
        this.f59027j = parcel.readInt();
    }

    public HybridADSetting backButtonImage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.f59024g = str;
            return this;
        }
        return (HybridADSetting) invokeL.objValue;
    }

    public HybridADSetting backSeparatorLength(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            this.f59027j = i2;
            return this;
        }
        return (HybridADSetting) invokeI.objValue;
    }

    public HybridADSetting closeButtonImage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f59025h = str;
            return this;
        }
        return (HybridADSetting) invokeL.objValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public String getBackButtonImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f59024g : (String) invokeV.objValue;
    }

    public int getBackSeparatorLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f59027j : invokeV.intValue;
    }

    public String getCloseButtonImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f59025h : (String) invokeV.objValue;
    }

    public int getSeparatorColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f59026i : invokeV.intValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f59023f : (String) invokeV.objValue;
    }

    public int getTitleBarColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f59020c : invokeV.intValue;
    }

    public int getTitleBarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f59019b : invokeV.intValue;
    }

    public int getTitleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f59021d : invokeV.intValue;
    }

    public int getTitleSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f59022e : invokeV.intValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a : invokeV.intValue;
    }

    public HybridADSetting separatorColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            this.f59026i = i2;
            return this;
        }
        return (HybridADSetting) invokeI.objValue;
    }

    public HybridADSetting title(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            this.f59023f = str;
            return this;
        }
        return (HybridADSetting) invokeL.objValue;
    }

    public HybridADSetting titleBarColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            this.f59020c = i2;
            return this;
        }
        return (HybridADSetting) invokeI.objValue;
    }

    public HybridADSetting titleBarHeight(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            this.f59019b = i2;
            return this;
        }
        return (HybridADSetting) invokeI.objValue;
    }

    public HybridADSetting titleColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            this.f59021d = i2;
            return this;
        }
        return (HybridADSetting) invokeI.objValue;
    }

    public HybridADSetting titleSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            this.f59022e = i2;
            return this;
        }
        return (HybridADSetting) invokeI.objValue;
    }

    public HybridADSetting type(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            this.a = i2;
            return this;
        }
        return (HybridADSetting) invokeI.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, parcel, i2) == null) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.f59019b);
            parcel.writeInt(this.f59020c);
            parcel.writeInt(this.f59021d);
            parcel.writeInt(this.f59022e);
            parcel.writeString(this.f59023f);
            parcel.writeString(this.f59024g);
            parcel.writeString(this.f59025h);
            parcel.writeInt(this.f59026i);
            parcel.writeInt(this.f59027j);
        }
    }
}
