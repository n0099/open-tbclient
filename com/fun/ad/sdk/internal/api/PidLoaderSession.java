package com.fun.ad.sdk.internal.api;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class PidLoaderSession {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List a;
    public final long b;
    public int c;
    public boolean d;
    public boolean e;
    public final SidSessionMeta f;
    public final AdDestroyListener g;
    public final Map h;

    /* loaded from: classes7.dex */
    public interface AdDestroyListener {
        void onDestroy(Object obj);
    }

    /* loaded from: classes7.dex */
    public interface ISelect {
        boolean selected(Object obj);
    }

    public PidLoaderSession(SidSessionMeta sidSessionMeta, AdDestroyListener adDestroyListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sidSessionMeta, adDestroyListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.c = 0;
        this.h = new HashMap();
        this.f = sidSessionMeta;
        this.g = adDestroyListener;
        this.b = System.currentTimeMillis();
    }

    public synchronized boolean cacheOrDestroy(Object obj, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, obj, z)) == null) {
            synchronized (this) {
                this.d = true;
                if (!this.e || z) {
                    this.a.add(obj);
                    return true;
                }
                this.g.onDestroy(obj);
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }

    public synchronized void destroyAd(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            synchronized (this) {
                Iterator it = this.a.iterator();
                int i = 0;
                while (it.hasNext()) {
                    if (!z) {
                        int i2 = i + 1;
                        if (i >= this.c) {
                            break;
                        }
                        i = i2;
                    }
                    Object next = it.next();
                    if (next != null) {
                        this.g.onDestroy(next);
                    }
                    it.remove();
                }
                this.c = 0;
                if (z) {
                    this.e = true;
                }
            }
        }
    }

    public synchronized int getFreeAdCount() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                int size = this.a.size();
                int i2 = this.c;
                i = (i2 < 0 || i2 >= size) ? 0 : size - i2;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public long getLid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : invokeV.longValue;
    }

    public SidSessionMeta getLoadSidSessionMeta() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f : (SidSessionMeta) invokeV.objValue;
    }

    public SidSessionMeta getShowSidSessionMeta(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj != null) {
                return (SidSessionMeta) this.h.get(obj);
            }
            return null;
        }
        return (SidSessionMeta) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
        if (r0 < r4.a.size()) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean hasAvailableAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                boolean z = true;
                if (this.c != 0 || this.a.isEmpty()) {
                    int i = this.c;
                    if (i > 0) {
                    }
                    z = false;
                    return z;
                }
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean isIncludeAd(Object obj) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            synchronized (this) {
                contains = this.a.contains(obj);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean isWaitFill() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                z = !this.d;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean iteratorAvailableAd(ISelect iSelect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, iSelect)) == null) {
            synchronized (this) {
                for (int i = this.c; i >= 0; i++) {
                    if (i >= this.a.size()) {
                        break;
                    } else if (iSelect.selected(this.a.get(i))) {
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized void markTerminated() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                this.d = true;
            }
        }
    }

    public synchronized Object peekAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                if (this.c >= this.a.size()) {
                    return null;
                }
                return this.a.get(this.c);
            }
        }
        return invokeV.objValue;
    }

    public synchronized Object pollAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            synchronized (this) {
                if (this.c >= this.a.size()) {
                    return null;
                }
                Object obj = this.a.get(this.c);
                this.c++;
                return obj;
            }
        }
        return invokeV.objValue;
    }

    public void setShowSidSessionMeta(Object obj, SidSessionMeta sidSessionMeta) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, obj, sidSessionMeta) == null) && isIncludeAd(obj)) {
            this.h.put(obj, sidSessionMeta);
        }
    }

    public synchronized boolean shouldBeRemoved() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this) {
                if (this.d) {
                    z = this.a.isEmpty();
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }
}
