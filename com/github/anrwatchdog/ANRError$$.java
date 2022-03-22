package com.github.anrwatchdog;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.github.anrwatchdog.ANRError;
import java.io.Serializable;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class ANRError$$ implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String _name;
    public final LinkedHashMap<Long, StackTraceElement[]> _stackMap;
    public final StackTraceElement[] _stackTrace;

    /* loaded from: classes6.dex */
    public class _Thread extends Throwable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ANRError$$ this$0;

        public /* synthetic */ _Thread(ANRError$$ aNRError$$, _Thread _thread, ANRError.a aVar) {
            this(aNRError$$, _thread);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                setStackTrace(this.this$0._stackTrace);
                return this;
            }
            return (Throwable) invokeV.objValue;
        }

        public LinkedHashMap<Long, StackTraceElement[]> getStackMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$0._stackMap : (LinkedHashMap) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public _Thread(ANRError$$ aNRError$$, _Thread _thread) {
            super(aNRError$$._name, _thread);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aNRError$$, _thread};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = aNRError$$;
        }
    }

    public /* synthetic */ ANRError$$(String str, LinkedHashMap linkedHashMap, ANRError.a aVar) {
        this(str, linkedHashMap);
    }

    public /* synthetic */ ANRError$$(String str, StackTraceElement[] stackTraceElementArr, ANRError.a aVar) {
        this(str, stackTraceElementArr);
    }

    public ANRError$$(String str, StackTraceElement[] stackTraceElementArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, stackTraceElementArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this._name = str;
        this._stackTrace = stackTraceElementArr;
        LinkedHashMap<Long, StackTraceElement[]> linkedHashMap = new LinkedHashMap<>();
        this._stackMap = linkedHashMap;
        linkedHashMap.put(Long.valueOf(System.currentTimeMillis()), this._stackTrace);
    }

    public ANRError$$(String str, LinkedHashMap<Long, StackTraceElement[]> linkedHashMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, linkedHashMap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this._name = str;
        this._stackTrace = linkedHashMap.entrySet().iterator().next().getValue();
        this._stackMap = linkedHashMap;
    }
}
