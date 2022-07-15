package com.kwad.components.model;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.a.a;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class FeedType {
    public static final /* synthetic */ FeedType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final FeedType FEED_TYPE_CONTENT_11;
    public static final FeedType FEED_TYPE_CONTENT_12;
    public static final FeedType FEED_TYPE_CONTENT_13;
    public static final FeedType FEED_TYPE_TEXT_ABOVE;
    public static final FeedType FEED_TYPE_TEXT_ABOVE_GROUP;
    public static final FeedType FEED_TYPE_TEXT_BELOW;
    public static final FeedType FEED_TYPE_TEXT_IMMERSE;
    public static final FeedType FEED_TYPE_TEXT_LEFT;
    public static final FeedType FEED_TYPE_TEXT_NEW;
    public static final FeedType FEED_TYPE_TEXT_RIGHT;
    public static final FeedType FEED_TYPE_UNKNOWN;
    public transient /* synthetic */ FieldHolder $fh;
    public int type;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-764207126, "Lcom/kwad/components/model/FeedType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-764207126, "Lcom/kwad/components/model/FeedType;");
                return;
            }
        }
        FEED_TYPE_UNKNOWN = new FeedType("FEED_TYPE_UNKNOWN", 0, 0);
        FEED_TYPE_TEXT_IMMERSE = new FeedType("FEED_TYPE_TEXT_IMMERSE", 1, 1);
        FEED_TYPE_TEXT_LEFT = new FeedType("FEED_TYPE_TEXT_LEFT", 2, 2);
        FEED_TYPE_TEXT_RIGHT = new FeedType("FEED_TYPE_TEXT_RIGHT", 3, 3);
        FEED_TYPE_TEXT_ABOVE = new FeedType("FEED_TYPE_TEXT_ABOVE", 4, 4);
        FEED_TYPE_TEXT_BELOW = new FeedType("FEED_TYPE_TEXT_BELOW", 5, 5);
        FEED_TYPE_TEXT_ABOVE_GROUP = new FeedType("FEED_TYPE_TEXT_ABOVE_GROUP", 6, 6);
        FEED_TYPE_TEXT_NEW = new FeedType("FEED_TYPE_TEXT_NEW", 7, 7);
        FEED_TYPE_CONTENT_11 = new FeedType("FEED_TYPE_CONTENT_11", 8, 11);
        FEED_TYPE_CONTENT_12 = new FeedType("FEED_TYPE_CONTENT_12", 9, 12);
        FeedType feedType = new FeedType("FEED_TYPE_CONTENT_13", 10, 13);
        FEED_TYPE_CONTENT_13 = feedType;
        $VALUES = new FeedType[]{FEED_TYPE_UNKNOWN, FEED_TYPE_TEXT_IMMERSE, FEED_TYPE_TEXT_LEFT, FEED_TYPE_TEXT_RIGHT, FEED_TYPE_TEXT_ABOVE, FEED_TYPE_TEXT_BELOW, FEED_TYPE_TEXT_ABOVE_GROUP, FEED_TYPE_TEXT_NEW, FEED_TYPE_CONTENT_11, FEED_TYPE_CONTENT_12, feedType};
    }

    public FeedType(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.type = i2;
    }

    public static boolean checkTypeValid(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adTemplate)) == null) {
            int Y = a.Y(d.i(adTemplate));
            int i = adTemplate.type;
            if (i > FEED_TYPE_TEXT_ABOVE_GROUP.type) {
                return true;
            }
            FeedType fromInt = fromInt(i);
            return Y != 1 ? Y != 2 ? Y == 3 && fromInt != FEED_TYPE_UNKNOWN : (fromInt == FEED_TYPE_UNKNOWN || fromInt == FEED_TYPE_TEXT_ABOVE_GROUP) ? false : true : fromInt == FEED_TYPE_TEXT_ABOVE || fromInt == FEED_TYPE_TEXT_BELOW;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public static FeedType fromInt(int i) {
        InterceptResult invokeI;
        FeedType[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            for (FeedType feedType : values()) {
                if (feedType.type == i) {
                    return feedType;
                }
            }
            return isH5Type(i) ? FEED_TYPE_TEXT_NEW : FEED_TYPE_UNKNOWN;
        }
        return (FeedType) invokeI.objValue;
    }

    public static boolean isH5Type(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) ? i == 7 || i == 8 || i >= 2000 : invokeI.booleanValue;
    }

    public static FeedType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? (FeedType) Enum.valueOf(FeedType.class, str) : (FeedType) invokeL.objValue;
    }

    public static FeedType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? (FeedType[]) $VALUES.clone() : (FeedType[]) invokeV.objValue;
    }

    public final int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.type : invokeV.intValue;
    }
}
