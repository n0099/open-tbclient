package d.a.s0.u0.g1;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes9.dex */
public class c extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f66005e;

    /* renamed from: f  reason: collision with root package name */
    public String f66006f;

    /* renamed from: g  reason: collision with root package name */
    public String f66007g;

    /* renamed from: h  reason: collision with root package name */
    public String f66008h;

    /* renamed from: i  reason: collision with root package name */
    public List<MediaData> f66009i;
    public int j;
    public boolean k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-166005290, "Ld/a/s0/u0/g1/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-166005290, "Ld/a/s0/u0/g1/c;");
                return;
            }
        }
        l = BdUniqueId.gen();
    }

    public c() {
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
        this.k = false;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f66007g : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f66006f : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f66005e : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? l : (BdUniqueId) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f66008h : (String) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public List<MediaData> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f66009i : (List) invokeV.objValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : invokeV.intValue;
    }

    public void q(AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adInfo) == null) || adInfo == null) {
            return;
        }
        this.f66005e = adInfo.portrait;
        this.f66006f = adInfo.ad_name;
        this.f66007g = adInfo.ad_desc;
        this.f66008h = adInfo.ad_url;
        this.j = adInfo.show_rule.intValue();
        if (adInfo.media != null) {
            this.f66009i = new ArrayList();
            for (Media media : adInfo.media) {
                MediaData mediaData = new MediaData();
                mediaData.parserProtobuf(media);
                this.f66009i.add(mediaData);
            }
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.k = z;
        }
    }
}
