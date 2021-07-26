package d.a.q0.p0.y.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.faceshop.emotioncenter.data.EmotionCenterData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.p0.s.w.b.a> f61960a;

    /* loaded from: classes8.dex */
    public class a implements d.a.p0.s.w.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f61961a;

        /* renamed from: b  reason: collision with root package name */
        public String f61962b;

        public a(c cVar, b2 b2Var, String str, String str2, String str3, String str4, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, b2Var, str, str2, str3, str4, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61961a = str;
            this.f61962b = str2;
        }

        @Override // d.a.p0.s.w.b.a
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f61961a : (String) invokeV.objValue;
        }

        @Override // d.a.p0.s.w.b.a
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f61962b : (String) invokeV.objValue;
        }
    }

    public c(List<EmotionCenterData.BannerData> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61960a = new ArrayList();
        if (list == null || ListUtils.isEmpty(list)) {
            return;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            EmotionCenterData.BannerData bannerData = list.get(i4);
            if (bannerData != null) {
                this.f61960a.add(new a(this, null, bannerData.url, bannerData.action, null, null, 0));
            }
        }
    }

    public List<d.a.p0.s.w.b.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f61960a : (List) invokeV.objValue;
    }
}
