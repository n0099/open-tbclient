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
/* loaded from: classes6.dex */
public class HybridADSetting implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<HybridADSetting> CREATOR;
    public static final int TYPE_REWARD_VIDEO = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f37952a;

    /* renamed from: b  reason: collision with root package name */
    public int f37953b;

    /* renamed from: c  reason: collision with root package name */
    public int f37954c;

    /* renamed from: d  reason: collision with root package name */
    public int f37955d;

    /* renamed from: e  reason: collision with root package name */
    public int f37956e;

    /* renamed from: f  reason: collision with root package name */
    public String f37957f;

    /* renamed from: g  reason: collision with root package name */
    public String f37958g;

    /* renamed from: h  reason: collision with root package name */
    public String f37959h;

    /* renamed from: i  reason: collision with root package name */
    public int f37960i;
    public int j;

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
            public final HybridADSetting createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new HybridADSetting(parcel) : (HybridADSetting) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final HybridADSetting[] newArray(int i2) {
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
        this.f37952a = 1;
        this.f37953b = 44;
        this.f37954c = -1;
        this.f37955d = -14013133;
        this.f37956e = 16;
        this.f37960i = -1776153;
        this.j = 16;
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
        this.f37952a = 1;
        this.f37953b = 44;
        this.f37954c = -1;
        this.f37955d = -14013133;
        this.f37956e = 16;
        this.f37960i = -1776153;
        this.j = 16;
        this.f37952a = parcel.readInt();
        this.f37953b = parcel.readInt();
        this.f37954c = parcel.readInt();
        this.f37955d = parcel.readInt();
        this.f37956e = parcel.readInt();
        this.f37957f = parcel.readString();
        this.f37958g = parcel.readString();
        this.f37959h = parcel.readString();
        this.f37960i = parcel.readInt();
        this.j = parcel.readInt();
    }

    public HybridADSetting backButtonImage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.f37958g = str;
            return this;
        }
        return (HybridADSetting) invokeL.objValue;
    }

    public HybridADSetting backSeparatorLength(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            this.j = i2;
            return this;
        }
        return (HybridADSetting) invokeI.objValue;
    }

    public HybridADSetting closeButtonImage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f37959h = str;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f37958g : (String) invokeV.objValue;
    }

    public int getBackSeparatorLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.j : invokeV.intValue;
    }

    public String getCloseButtonImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f37959h : (String) invokeV.objValue;
    }

    public int getSeparatorColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f37960i : invokeV.intValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f37957f : (String) invokeV.objValue;
    }

    public int getTitleBarColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f37954c : invokeV.intValue;
    }

    public int getTitleBarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f37953b : invokeV.intValue;
    }

    public int getTitleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f37955d : invokeV.intValue;
    }

    public int getTitleSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f37956e : invokeV.intValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f37952a : invokeV.intValue;
    }

    public HybridADSetting separatorColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            this.f37960i = i2;
            return this;
        }
        return (HybridADSetting) invokeI.objValue;
    }

    public HybridADSetting title(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            this.f37957f = str;
            return this;
        }
        return (HybridADSetting) invokeL.objValue;
    }

    public HybridADSetting titleBarColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            this.f37954c = i2;
            return this;
        }
        return (HybridADSetting) invokeI.objValue;
    }

    public HybridADSetting titleBarHeight(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            this.f37953b = i2;
            return this;
        }
        return (HybridADSetting) invokeI.objValue;
    }

    public HybridADSetting titleColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            this.f37955d = i2;
            return this;
        }
        return (HybridADSetting) invokeI.objValue;
    }

    public HybridADSetting titleSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            this.f37956e = i2;
            return this;
        }
        return (HybridADSetting) invokeI.objValue;
    }

    public HybridADSetting type(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            this.f37952a = i2;
            return this;
        }
        return (HybridADSetting) invokeI.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, parcel, i2) == null) {
            parcel.writeInt(this.f37952a);
            parcel.writeInt(this.f37953b);
            parcel.writeInt(this.f37954c);
            parcel.writeInt(this.f37955d);
            parcel.writeInt(this.f37956e);
            parcel.writeString(this.f37957f);
            parcel.writeString(this.f37958g);
            parcel.writeString(this.f37959h);
            parcel.writeInt(this.f37960i);
            parcel.writeInt(this.j);
        }
    }
}
