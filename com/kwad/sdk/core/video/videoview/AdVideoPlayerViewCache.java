package com.kwad.sdk.core.video.videoview;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class AdVideoPlayerViewCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, WeakReference<b>> f65099a;

    /* renamed from: com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class Holder {
        public static final /* synthetic */ Holder[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Holder INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;
        public AdVideoPlayerViewCache mInstance;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(156350279, "Lcom/kwad/sdk/core/video/videoview/AdVideoPlayerViewCache$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(156350279, "Lcom/kwad/sdk/core/video/videoview/AdVideoPlayerViewCache$Holder;");
                    return;
                }
            }
            Holder holder = new Holder("INSTANCE", 0);
            INSTANCE = holder;
            $VALUES = new Holder[]{holder};
        }

        public Holder(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
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
            this.mInstance = new AdVideoPlayerViewCache(null);
        }

        public static Holder valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Holder) Enum.valueOf(Holder.class, str) : (Holder) invokeL.objValue;
        }

        public static Holder[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Holder[]) $VALUES.clone() : (Holder[]) invokeV.objValue;
        }

        public AdVideoPlayerViewCache getInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mInstance : (AdVideoPlayerViewCache) invokeV.objValue;
        }
    }

    public AdVideoPlayerViewCache() {
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
        this.f65099a = new HashMap<>(1);
    }

    public /* synthetic */ AdVideoPlayerViewCache(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static AdVideoPlayerViewCache a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Holder.INSTANCE.getInstance() : (AdVideoPlayerViewCache) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f65099a.remove(str);
        }
    }

    public void a(String str, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar) == null) {
            this.f65099a.put(str, new WeakReference<>(bVar));
        }
    }

    public b b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            WeakReference<b> weakReference = this.f65099a.get(str);
            if (weakReference != null) {
                b bVar = weakReference.get();
                if (bVar != null) {
                    return bVar;
                }
                this.f65099a.remove(str);
            }
            return null;
        }
        return (b) invokeL.objValue;
    }
}
