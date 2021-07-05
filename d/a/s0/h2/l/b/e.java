package d.a.s0.h2.l.b;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes9.dex */
public class e implements d, PreLoadImageProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f60898e;

    /* renamed from: f  reason: collision with root package name */
    public int f60899f;

    /* renamed from: g  reason: collision with root package name */
    public int f60900g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<PreLoadImageInfo> f60901h;

    /* renamed from: i  reason: collision with root package name */
    public String f60902i;

    public e(ExcContent excContent) {
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {excContent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (excContent == null || (l = excContent.type) == null || !l.equals(3L)) {
            return;
        }
        this.f60901h = new ArrayList<>(1);
        this.f60898e = excContent.src;
        String str = excContent.bsize;
        this.f60902i = str;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f60899f = d.a.c.e.m.b.d(split[0], 0);
                this.f60900g = d.a.c.e.m.b.d(split[1], 0);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f60899f <= 0) {
            this.f60899f = 1;
        }
        if (this.f60900g <= 0) {
            this.f60900g = 1;
        }
        String str2 = excContent.cdn_src;
        PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
        preLoadImageInfo.procType = 17;
        preLoadImageInfo.height = this.f60900g;
        preLoadImageInfo.width = this.f60899f;
        if (StringUtils.isNull(str2)) {
            preLoadImageInfo.imgUrl = this.f60898e;
        } else {
            preLoadImageInfo.imgUrl = str2;
        }
        this.f60901h.add(preLoadImageInfo);
    }

    public int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 <= 0) {
                return 0;
            }
            return (i2 * this.f60900g) / this.f60899f;
        }
        return invokeI.intValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60898e : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60901h : (ArrayList) invokeV.objValue;
    }

    @Override // d.a.s0.h2.l.b.d
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }
}
