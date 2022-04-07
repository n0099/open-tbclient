package com.fun.ad.sdk.internal.api.ripper;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.MD5Utils;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class RippedAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String appName;
    public final String appPkg;
    public final String appUrl;
    public final String clickUrl;
    public final String convUrl;
    public final String corporation;
    public final String deepLinkUrl;
    public final String description;
    public final String iconUrl;
    public final String imageUrl;
    public final boolean isDeepLinkAd;
    public final String title;
    public final String uniqueId;
    public final String videoImageUrl;
    public final String videoUrl;

    /* loaded from: classes4.dex */
    public interface Acceptor<T> {
        String accept(T t);
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public RippedAd build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new RippedAd(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m) : (RippedAd) invokeV.objValue;
        }

        public Builder setAppName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.e = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAppPkg(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAppUrl(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.g = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setClickUrl(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.k = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setConvUrl(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.m = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setCorporation(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.a = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setDeepLinkUrl(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.l = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setDescription(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.c = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setIconUrl(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.d = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setImageUrl(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                this.h = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setTitle(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.b = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setVideoImageUrl(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.i = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setVideoUrl(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
                this.j = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    public RippedAd(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.corporation = str;
        this.title = str2;
        this.description = str3;
        this.iconUrl = str4;
        this.appName = str5;
        this.appPkg = str6;
        this.appUrl = str7;
        this.imageUrl = str8;
        this.videoImageUrl = str9;
        this.videoUrl = str10;
        this.clickUrl = str11;
        this.deepLinkUrl = str12;
        this.convUrl = str13;
        this.isDeepLinkAd = !TextUtils.isEmpty(str12);
        this.uniqueId = MD5Utils.getMD5String(UUID.randomUUID().toString());
    }

    public static String combineStrWithComma(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(',');
                    }
                    sb.append(str);
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String combineStrWithComma(JSONArray jSONArray, Acceptor<JSONObject> acceptor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONArray, acceptor)) == null) {
            if (jSONArray == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (int i = 0; i < jSONArray.length(); i++) {
                String accept = acceptor.accept(jSONArray.getJSONObject(i));
                if (!TextUtils.isEmpty(accept)) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(',');
                    }
                    sb.append(accept);
                }
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
