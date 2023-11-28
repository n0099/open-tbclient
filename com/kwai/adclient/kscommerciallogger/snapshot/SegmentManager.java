package com.kwai.adclient.kscommerciallogger.snapshot;

import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class SegmentManager {
    public static final /* synthetic */ SegmentManager[] $VALUES;
    public static /* synthetic */ Interceptable $ic = null;
    public static final SegmentManager Instance;
    public static final int expiredThresholds = 900000;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasInit;
    public boolean isDebug;
    public long lastAutoClearTime;
    public LruCache<String, Set<c>> mSnapshots;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-690721629, "Lcom/kwai/adclient/kscommerciallogger/snapshot/SegmentManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-690721629, "Lcom/kwai/adclient/kscommerciallogger/snapshot/SegmentManager;");
                return;
            }
        }
        SegmentManager segmentManager = new SegmentManager("Instance", 0);
        Instance = segmentManager;
        $VALUES = new SegmentManager[]{segmentManager};
    }

    public static SegmentManager[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (SegmentManager[]) $VALUES.clone();
        }
        return (SegmentManager[]) invokeV.objValue;
    }

    public final int cacheLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LruCache<String, Set<c>> lruCache = this.mSnapshots;
            if (lruCache == null) {
                return 0;
            }
            return lruCache.maxSize();
        }
        return invokeV.intValue;
    }

    public final String loadSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return UUID.randomUUID().toString();
        }
        return (String) invokeV.objValue;
    }

    public final synchronized int segmentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this) {
                if (this.mSnapshots == null) {
                    return 0;
                }
                return this.mSnapshots.size();
            }
        }
        return invokeV.intValue;
    }

    public final synchronized int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            synchronized (this) {
                if (this.mSnapshots == null) {
                    return 0;
                }
                return this.mSnapshots.snapshot().size();
            }
        }
        return invokeV.intValue;
    }

    public SegmentManager(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isDebug = false;
        this.hasInit = false;
    }

    public final void clearBySegment(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.mSnapshots != null) {
            synchronized (this) {
                Set<c> set = this.mSnapshots.get(str);
                c cVar = new c(str2);
                if (set != null && set.contains(cVar)) {
                    this.mSnapshots.remove(str);
                    set.remove(cVar);
                    if (set.size() > 0) {
                        this.mSnapshots.put(str, set);
                    }
                }
                autoClear();
            }
        }
    }

    private void autoClear() {
        LruCache<String, Set<c>> lruCache;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && (lruCache = this.mSnapshots) != null && lruCache.size() != 0 && System.currentTimeMillis() - this.lastAutoClearTime >= com.heytap.mcssdk.constant.a.h) {
            this.lastAutoClearTime = System.currentTimeMillis();
            for (Map.Entry<String, Set<c>> entry : this.mSnapshots.snapshot().entrySet()) {
                String key = entry.getKey();
                Set<c> value = entry.getValue();
                if (value != null) {
                    Iterator<c> it = value.iterator();
                    this.mSnapshots.remove(key);
                    while (it.hasNext()) {
                        if (this.lastAutoClearTime - it.next().MP() >= com.heytap.mcssdk.constant.a.h) {
                            it.remove();
                        }
                    }
                    if (value.size() > 0) {
                        this.mSnapshots.put(key, value);
                    }
                }
            }
        }
    }

    public final synchronized Map.Entry<String, Integer> mostUsedSegmentInfo() {
        InterceptResult invokeV;
        Map.Entry<String, Integer> entry;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            synchronized (this) {
                HashMap hashMap = new HashMap();
                for (Map.Entry<String, Set<c>> entry2 : this.mSnapshots.snapshot().entrySet()) {
                    for (c cVar : entry2.getValue()) {
                        Integer num = (Integer) hashMap.get(cVar.getName());
                        if (num == null) {
                            hashMap.put(cVar.getName(), 1);
                        } else {
                            hashMap.put(cVar.getName(), Integer.valueOf(num.intValue() + 1));
                        }
                    }
                }
                entry = (Map.Entry) Collections.max(new ArrayList(hashMap.entrySet()), new Comparator<Map.Entry<String, Integer>>(this) { // from class: com.kwai.adclient.kscommerciallogger.snapshot.SegmentManager.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SegmentManager aSN;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.aSN = this;
                    }

                    public static int a(Map.Entry<String, Integer> entry3, Map.Entry<String, Integer> entry4) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(65537, null, entry3, entry4)) == null) {
                            return entry3.getValue().compareTo(entry4.getValue());
                        }
                        return invokeLL.intValue;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // java.util.Comparator
                    public final /* synthetic */ int compare(Map.Entry<String, Integer> entry3, Map.Entry<String, Integer> entry4) {
                        return a(entry3, entry4);
                    }
                });
            }
            return entry;
        }
        return (Map.Entry) invokeV.objValue;
    }

    public static SegmentManager valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (SegmentManager) Enum.valueOf(SegmentManager.class, str);
        }
        return (SegmentManager) invokeL.objValue;
    }

    public final void clearBySessionId(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && !TextUtils.isEmpty(str) && this.mSnapshots != null) {
            synchronized (this) {
                this.mSnapshots.remove(str);
                autoClear();
            }
        }
    }

    @Deprecated
    public final void clearBySegment(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !TextUtils.isEmpty(str) && this.mSnapshots != null) {
            synchronized (this) {
                for (Map.Entry<String, Set<c>> entry : this.mSnapshots.snapshot().entrySet()) {
                    clearBySegment(entry.getKey(), str);
                }
            }
        }
    }

    public final synchronized void init(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (!this.hasInit) {
                    this.isDebug = z;
                    if (i > 0) {
                        this.mSnapshots = new LruCache<String, Set<c>>(this, i) { // from class: com.kwai.adclient.kscommerciallogger.snapshot.SegmentManager.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ SegmentManager aSN;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(i);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(i)};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        super(((Integer) newInitContext.callArgs[0]).intValue());
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.aSN = this;
                            }

                            public static int f(Set<c> set) {
                                InterceptResult invokeL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeL = interceptable2.invokeL(65537, null, set)) == null) {
                                    return set.size();
                                }
                                return invokeL.intValue;
                            }

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                            @Override // android.util.LruCache
                            public final /* synthetic */ int sizeOf(String str, Set<c> set) {
                                return f(set);
                            }
                        };
                    }
                    this.hasInit = true;
                }
            }
        }
    }

    public final synchronized boolean isOverThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                if (cacheLimit() > 0 && segmentSize() != 0) {
                    if (BigDecimal.valueOf(segmentSize() / cacheLimit()).setScale(2, RoundingMode.HALF_UP).doubleValue() < 0.7d) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final JSONArray justLoadInfoBySessionId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            JSONArray jSONArray = new JSONArray();
            LruCache<String, Set<c>> lruCache = this.mSnapshots;
            if (lruCache != null && lruCache.size() != 0) {
                synchronized (this) {
                    Set<c> set = this.mSnapshots.get(str);
                    if (set != null) {
                        for (c cVar : set) {
                            jSONArray.put(cVar.gG(str));
                        }
                    }
                }
                return jSONArray;
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public final JSONArray loadInfoBySessionId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            JSONArray jSONArray = new JSONArray();
            LruCache<String, Set<c>> lruCache = this.mSnapshots;
            if (lruCache != null && lruCache.size() != 0) {
                synchronized (this) {
                    Set<c> set = this.mSnapshots.get(str);
                    if (set != null) {
                        for (c cVar : set) {
                            jSONArray.put(cVar.gG(str));
                        }
                        this.mSnapshots.remove(str);
                    }
                }
                return jSONArray;
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public final c loadSegment(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            return loadSegment(str, str2, 10);
        }
        return (c) invokeLL.objValue;
    }

    public final d loadSpan(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            return loadSpan(str, str2, TtmlNode.TAG_SPAN);
        }
        return (d) invokeLL.objValue;
    }

    public final c loadSegment(@NonNull String str, @NonNull String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048585, this, str, str2, i)) == null) {
            if (this.mSnapshots == null) {
                if (!this.hasInit && this.isDebug) {
                    throw new IllegalStateException("you need init first");
                }
                return new a(SchemeCollecter.CLASSIFY_EMPTY);
            }
            synchronized (this) {
                Set<c> set = this.mSnapshots.get(str);
                if (set != null) {
                    for (c cVar : set) {
                        if (cVar.getName().equals(str2)) {
                            return cVar;
                        }
                    }
                }
                c cVar2 = new c(str2, i);
                if (set != null) {
                    this.mSnapshots.remove(str);
                    set.add(cVar2);
                    this.mSnapshots.put(str, set);
                } else {
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    linkedHashSet.add(cVar2);
                    this.mSnapshots.put(str, linkedHashSet);
                }
                autoClear();
                return cVar2;
            }
        }
        return (c) invokeLLI.objValue;
    }

    public final d loadSpan(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, str, str2, str3)) == null) {
            return loadSegment(str, str2).gF(str3);
        }
        return (d) invokeLLL.objValue;
    }
}
