package com.vivo.push.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class UPSNotificationMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CUSTOM = 3;
    public static final int ISMACROREPLACE = 1;
    public static final int OPENACTIVITY = 4;
    public static final int OPENAPP = 1;
    public static final int OPENURL = 2;
    public static final int UNKNOWN = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public String mAdClickCheckUrl;
    public int mCompatibleType;
    public String mContent;
    public String mCoverUrl;
    public String mIconUrl;
    public int mIsMacroReplace;
    public long mMsgId;
    public int mNotifyType;
    public Map mParams;
    public String mPurePicUrl;
    public boolean mShowTime;
    public String mSkipContent;
    public int mSkipType;
    public int mTargetType;
    public String mTitle;
    public String mTragetContent;

    public UPSNotificationMessage() {
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
        this.mParams = new HashMap();
    }

    public void clearCoverUrl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mIconUrl = "";
        }
    }

    public void clearPurePicUrl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mPurePicUrl = "";
        }
    }

    public String getAdClickCheckUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mAdClickCheckUrl;
        }
        return (String) invokeV.objValue;
    }

    public int getCompatibleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mCompatibleType;
        }
        return invokeV.intValue;
    }

    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mContent;
        }
        return (String) invokeV.objValue;
    }

    public String getCoverUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mCoverUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mIconUrl;
        }
        return (String) invokeV.objValue;
    }

    public int getIsMacroReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mIsMacroReplace;
        }
        return invokeV.intValue;
    }

    public long getMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mMsgId;
        }
        return invokeV.longValue;
    }

    public int getNotifyType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mNotifyType;
        }
        return invokeV.intValue;
    }

    public Map getParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mParams;
        }
        return (Map) invokeV.objValue;
    }

    public String getPurePicUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mPurePicUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getSkipContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mSkipContent;
        }
        return (String) invokeV.objValue;
    }

    public int getSkipType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mSkipType;
        }
        return invokeV.intValue;
    }

    public int getTargetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mTargetType;
        }
        return invokeV.intValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mTitle;
        }
        return (String) invokeV.objValue;
    }

    public String getTragetContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mTragetContent;
        }
        return (String) invokeV.objValue;
    }

    public boolean isMacroReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.mIsMacroReplace == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mShowTime;
        }
        return invokeV.booleanValue;
    }

    public void setAdClickCheckUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.mAdClickCheckUrl = str;
        }
    }

    public void setCompatibleType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.mCompatibleType = i;
        }
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.mContent = str;
        }
    }

    public void setCoverUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.mCoverUrl = str;
        }
    }

    public void setIconUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.mIconUrl = str;
        }
    }

    public void setIsMacroReplace(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.mIsMacroReplace = i;
        }
    }

    public void setMsgId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j) == null) {
            this.mMsgId = j;
        }
    }

    public void setNotifyType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.mNotifyType = i;
        }
    }

    public void setParams(Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, map) == null) {
            this.mParams = map;
        }
    }

    public void setPurePicUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.mPurePicUrl = str;
        }
    }

    public void setShowTime(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.mShowTime = z;
        }
    }

    public void setSkipContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.mSkipContent = str;
        }
    }

    public void setSkipType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.mSkipType = i;
        }
    }

    public void setTargetType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.mTargetType = i;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.mTitle = str;
        }
    }

    public void setTragetContext(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.mTragetContent = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return "UPSNotificationMessage{mTargetType=" + this.mTargetType + ", mTragetContent='" + this.mTragetContent + "', mTitle='" + this.mTitle + "', mContent='" + this.mContent + "', mNotifyType=" + this.mNotifyType + ", mPurePicUrl='" + this.mPurePicUrl + "', mIconUrl='" + this.mIconUrl + "', mCoverUrl='" + this.mCoverUrl + "', mSkipContent='" + this.mSkipContent + "', mSkipType=" + this.mSkipType + ", mShowTime=" + this.mShowTime + ", mMsgId=" + this.mMsgId + ", mParams=" + this.mParams + '}';
        }
        return (String) invokeV.objValue;
    }
}
