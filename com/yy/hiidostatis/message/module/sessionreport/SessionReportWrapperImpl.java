package com.yy.hiidostatis.message.module.sessionreport;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.SharedThreadTimer;
import com.yy.hiidostatis.inner.util.SharedTimerTask;
import com.yy.hiidostatis.message.SessionReport;
import com.yy.hiidostatis.message.SessionReportWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class SessionReportWrapperImpl implements SessionReportWrapper, SessionReport.AfterFlush, SessionReport.Processor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Long, OnTimer> cache;
    public Map<String, Set<String>> exclude;
    public SharedThreadTimer globeTimer;
    public SessionReport sessionReport;
    public Set<String> sessions;

    /* loaded from: classes7.dex */
    public class OnTimer extends SharedTimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, List<String>> eventIds;
        public Set<String> globe;
        public final /* synthetic */ SessionReportWrapperImpl this$0;

        public OnTimer(SessionReportWrapperImpl sessionReportWrapperImpl) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sessionReportWrapperImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sessionReportWrapperImpl;
            this.eventIds = new HashMap();
            this.globe = new HashSet();
        }

        public synchronized void addEventId(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                synchronized (this) {
                    List<String> list = this.eventIds.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.eventIds.put(str, list);
                    }
                    list.add(str2);
                }
            }
        }

        public synchronized void addGlobe(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                synchronized (this) {
                    this.globe.add(str);
                }
            }
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    ArrayList<String> arrayList = new ArrayList();
                    for (String str : this.globe) {
                        if (!this.this$0.sessionClosed(str)) {
                            this.this$0.sessionReport.flushSessionAll(str, (Set) this.this$0.exclude.get(str));
                        } else {
                            arrayList.add(str);
                        }
                    }
                    for (Map.Entry<String, List<String>> entry : this.eventIds.entrySet()) {
                        if (this.this$0.sessionClosed(entry.getKey())) {
                            arrayList.add(entry.getKey());
                        } else {
                            for (String str2 : entry.getValue()) {
                                this.this$0.sessionReport.flushSession(entry.getKey(), str2);
                            }
                        }
                    }
                    for (String str3 : arrayList) {
                        this.globe.remove(str3);
                        this.eventIds.remove(str3);
                    }
                }
            }
        }
    }

    public SessionReportWrapperImpl(SessionReport sessionReport) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sessionReport};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.exclude = new ConcurrentHashMap();
        this.cache = new HashMap();
        this.sessions = new HashSet();
        this.sessionReport = sessionReport;
    }

    private synchronized void removeSession(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            synchronized (this) {
                this.sessions.remove(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean sessionClosed(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            synchronized (this) {
                z = !this.sessions.contains(str);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // com.yy.hiidostatis.message.SessionReportWrapper
    public synchronized void beginSession(String str, String str2, long j, Map<String, Long> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Long.valueOf(j), map}) == null) {
            synchronized (this) {
                this.sessionReport.beginSession(str, str2, this, this);
                this.sessions.add(str);
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i > 0) {
                    OnTimer onTimer = this.cache.get(Long.valueOf(j));
                    if (onTimer == null) {
                        OnTimer onTimer2 = new OnTimer(this);
                        onTimer2.addGlobe(str);
                        this.cache.put(Long.valueOf(j), onTimer2);
                        if (this.globeTimer == null) {
                            this.globeTimer = new SharedThreadTimer();
                        }
                        this.globeTimer.schedule(onTimer2, j, j);
                    } else {
                        onTimer.addGlobe(str);
                    }
                }
                if (map != null) {
                    HashMap hashMap = new HashMap();
                    HashSet hashSet = new HashSet();
                    for (Map.Entry<String, Long> entry : map.entrySet()) {
                        OnTimer onTimer3 = this.cache.get(entry.getValue());
                        if (onTimer3 == null) {
                            onTimer3 = new OnTimer(this);
                            this.cache.put(entry.getValue(), onTimer3);
                            hashMap.put(entry.getValue(), onTimer3);
                        }
                        onTimer3.addEventId(str, entry.getKey());
                        hashSet.add(entry.getKey());
                    }
                    if (i > 0) {
                        this.exclude.put(str, hashSet);
                    }
                    if (this.globeTimer == null) {
                        this.globeTimer = new SharedThreadTimer();
                    }
                    for (Map.Entry entry2 : hashMap.entrySet()) {
                        this.globeTimer.schedule((SharedTimerTask) entry2.getValue(), ((Long) entry2.getKey()).longValue(), ((Long) entry2.getKey()).longValue());
                    }
                }
            }
        }
    }

    @Override // com.yy.hiidostatis.message.SessionReportWrapper
    public void closeSession(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.sessionReport.closeSession(str);
            this.exclude.remove(str);
            removeSession(str);
        }
    }

    @Override // com.yy.hiidostatis.message.SessionReportWrapper
    public boolean flushSession(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) ? this.sessionReport.flushSession(str, str2) : invokeLL.booleanValue;
    }

    public boolean flushSessionAll(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? flushSessionAll(str, null) : invokeL.booleanValue;
    }

    @Override // com.yy.hiidostatis.message.SessionReport.Processor
    public SessionReport.StatisContentAble process(SessionReport.StatisContentAble statisContentAble, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, statisContentAble, str, obj)) == null) {
            EventValue eventValue = (EventValue) obj;
            CommonSessionState commonSessionState = (CommonSessionState) statisContentAble;
            if (commonSessionState == null) {
                commonSessionState = new CommonSessionState();
            }
            String dimIdentification = eventValue.dimIdentification();
            CalValue calValue = commonSessionState.get(dimIdentification, eventValue.key);
            if (calValue == null) {
                calValue = new CalValue();
            }
            commonSessionState.put(dimIdentification, eventValue.key, eventValue.calAction.cal(eventValue.value, calValue), eventValue.extra);
            return commonSessionState;
        }
        return (SessionReport.StatisContentAble) invokeLLL.objValue;
    }

    @Override // com.yy.hiidostatis.message.SessionReportWrapper
    public boolean pushToSession(String str, String str2, List<EventValue> list, Map<String, String> map, Map<String, String> map2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048583, this, str, str2, list, map, map2)) == null) {
            for (EventValue eventValue : list) {
                eventValue.dimens = map;
                eventValue.extra = map2;
                this.sessionReport.pushToSession(str, str2, eventValue);
            }
            return true;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.yy.hiidostatis.message.SessionReport.AfterFlush
    public SessionReport.StatisContentAble reset(String str, SessionReport.StatisContentAble statisContentAble) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, statisContentAble)) == null) {
            return null;
        }
        return (SessionReport.StatisContentAble) invokeLL.objValue;
    }

    @Override // com.yy.hiidostatis.message.SessionReportWrapper
    public boolean flushSessionAll(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, set)) == null) ? this.sessionReport.flushSessionAll(str, set) : invokeLL.booleanValue;
    }

    @Override // com.yy.hiidostatis.message.SessionReportWrapper
    public boolean pushToSession(String str, String str2, CalAction calAction, String str3, Number number, Map<String, String> map, Map<String, String> map2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, calAction, str3, number, map, map2})) == null) {
            EventValue eventValue = new EventValue(calAction, str3, number);
            eventValue.dimens = map;
            eventValue.extra = map2;
            return this.sessionReport.pushToSession(str, str2, eventValue);
        }
        return invokeCommon.booleanValue;
    }
}
