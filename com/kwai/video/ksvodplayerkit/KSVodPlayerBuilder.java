package com.kwai.video.ksvodplayerkit;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.player.kwai_player.KwaiPlayerVodBuilder;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class KSVodPlayerBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f39849a;

    /* renamed from: b  reason: collision with root package name */
    public String f39850b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f39851c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f39852d;

    /* renamed from: e  reason: collision with root package name */
    public l f39853e;

    /* renamed from: f  reason: collision with root package name */
    public VodPlayEnterType f39854f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f39855g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwai.video.ksvodplayerkit.b.h f39856h;

    /* renamed from: i  reason: collision with root package name */
    public int f39857i;
    public int j;
    public Map<String, String> k;
    public String l;
    public com.kwai.video.ksvodplayerkit.c.b m;
    public boolean n;
    public long o;
    public KwaiPlayerVodBuilder p;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class VodPlayEnterType {
        public static final /* synthetic */ VodPlayEnterType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final VodPlayEnterType CLICK;
        public static final VodPlayEnterType SLIDE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2120106915, "Lcom/kwai/video/ksvodplayerkit/KSVodPlayerBuilder$VodPlayEnterType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2120106915, "Lcom/kwai/video/ksvodplayerkit/KSVodPlayerBuilder$VodPlayEnterType;");
                    return;
                }
            }
            SLIDE = new VodPlayEnterType("SLIDE", 0);
            VodPlayEnterType vodPlayEnterType = new VodPlayEnterType("CLICK", 1);
            CLICK = vodPlayEnterType;
            $VALUES = new VodPlayEnterType[]{SLIDE, vodPlayEnterType};
        }

        public VodPlayEnterType(String str, int i2) {
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
                }
            }
        }

        public static VodPlayEnterType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (VodPlayEnterType) Enum.valueOf(VodPlayEnterType.class, str) : (VodPlayEnterType) invokeL.objValue;
        }

        public static VodPlayEnterType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (VodPlayEnterType[]) $VALUES.clone() : (VodPlayEnterType[]) invokeV.objValue;
        }
    }

    public KSVodPlayerBuilder(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39854f = VodPlayEnterType.CLICK;
        this.f39855g = true;
        this.f39857i = 0;
        this.l = "N/A";
        if (context == null) {
            throw new IllegalArgumentException("Wrong Input Arguments! Context con't be null!");
        }
        this.p = new KwaiPlayerVodBuilder(context);
        this.f39849a = context;
    }

    public KSVodPlayerBuilder a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.f39850b = str;
            return this;
        }
        return (KSVodPlayerBuilder) invokeL.objValue;
    }

    public KSVodPlayerBuilder a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            this.k = map;
            return this;
        }
        return (KSVodPlayerBuilder) invokeL.objValue;
    }

    public KSVodPlayerBuilder a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.n = z;
            return this;
        }
        return (KSVodPlayerBuilder) invokeZ.objValue;
    }

    public KwaiPlayerVodBuilder a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.p : (KwaiPlayerVodBuilder) invokeV.objValue;
    }

    public g b() {
        InterceptResult invokeV;
        List<String> list;
        com.kwai.video.ksvodplayerkit.b.h hVar;
        List<com.kwai.video.ksvodplayerkit.b.i> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f39849a != null) {
                String str = this.f39850b;
                if ((str == null || TextUtils.isEmpty(str)) && (((list = this.f39851c) == null || list.isEmpty()) && ((hVar = this.f39856h) == null || (list2 = hVar.f39879b) == null || list2.isEmpty()))) {
                    throw new IllegalArgumentException("Wrong Input Arguments! Please SetDatasource!");
                }
                return new g(this);
            }
            throw new IllegalArgumentException("Wrong Input Arguments! Please set context!");
        }
        return (g) invokeV.objValue;
    }
}
