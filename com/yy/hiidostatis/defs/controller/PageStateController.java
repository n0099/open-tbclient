package com.yy.hiidostatis.defs.controller;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.OnStatisListener;
import com.yy.hiidostatis.defs.interf.IStatisAPI;
import com.yy.hiidostatis.inner.util.Util;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes2.dex */
public class PageStateController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile Context context;
    public volatile OnStatisListener listener;
    public volatile ConcurrentLinkedQueue<PageBean> pages;
    public volatile long periodTime;
    public volatile StringBuffer record;
    public volatile IStatisAPI statisAPI;

    /* loaded from: classes2.dex */
    public static class PageBean {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String page;
        public long stime;

        public PageBean(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.page = str;
            this.stime = j;
        }

        public String getPage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.page : (String) invokeV.objValue;
        }

        public long getStime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.stime : invokeV.longValue;
        }

        public void setPage(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.page = str;
            }
        }

        public void setStime(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
                this.stime = j;
            }
        }
    }

    public PageStateController(IStatisAPI iStatisAPI, Context context, OnStatisListener onStatisListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iStatisAPI, context, onStatisListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.pages = new ConcurrentLinkedQueue<>();
        this.record = new StringBuffer(512);
        this.statisAPI = iStatisAPI;
        this.context = context;
        this.listener = onStatisListener;
    }

    private void sendToServer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, this, z) == null) {
            String stringBuffer = this.record.toString();
            this.record.setLength(0);
            long currentTimeMillis = System.currentTimeMillis() - this.periodTime;
            this.periodTime = z ? 0L : System.currentTimeMillis();
            if (stringBuffer.length() == 0) {
                return;
            }
            this.statisAPI.reportPageState(this.listener != null ? this.listener.getCurrentUid() : 0L, stringBuffer.substring(0, stringBuffer.length() - 1), currentTimeMillis);
        }
    }

    public void onStart(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || str == null || str.isEmpty()) {
            return;
        }
        this.pages.add(new PageBean(str, System.currentTimeMillis()));
        if (this.periodTime == 0) {
            this.periodTime = System.currentTimeMillis();
        }
    }

    public boolean onStop(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            Iterator<PageBean> it = this.pages.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PageBean next = it.next();
                if (next.getPage().equals(str)) {
                    this.pages.remove(next);
                    this.record.append(String.format("%s:%d:%d|", Util.replaceEncode(next.getPage(), ":"), Long.valueOf(next.getStime()), Long.valueOf(System.currentTimeMillis() - next.getStime())));
                    break;
                }
            }
            if (this.pages.isEmpty() || this.record.length() > 3000) {
                sendToServer(this.pages.isEmpty());
            }
            return this.pages.isEmpty();
        }
        return invokeL.booleanValue;
    }
}
