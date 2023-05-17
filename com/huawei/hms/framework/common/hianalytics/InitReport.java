package com.huawei.hms.framework.common.hianalytics;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.common.Logger;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes9.dex */
public class InitReport {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EVENT_LIMIT = 10;
    public static final String TAG = "HaReport";
    public static List<Runnable> eventsToReport;
    public static boolean hasConnectNet;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2057554313, "Lcom/huawei/hms/framework/common/hianalytics/InitReport;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2057554313, "Lcom/huawei/hms/framework/common/hianalytics/InitReport;");
                return;
            }
        }
        eventsToReport = new CopyOnWriteArrayList();
    }

    public InitReport() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void enableConnectNet() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            hasConnectNet = true;
            try {
                HianalyticsHelper.getInstance().getReportExecutor().submit(new Runnable() { // from class: com.huawei.hms.framework.common.hianalytics.InitReport.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            InitReport.submitAllEvents();
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
                Logger.e(TAG, "the thread submit has rejectedExecutionException!");
            } catch (Throwable unused2) {
                Logger.e(TAG, "the thread submit has fatal error!");
            }
        }
    }

    public static void reportWhenInit(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, runnable) == null) {
            if (hasConnectNet) {
                try {
                    HianalyticsHelper.getInstance().getReportExecutor().execute(runnable);
                } catch (RejectedExecutionException unused) {
                    Logger.e(TAG, "the thread submit has rejectedExecutionException!");
                } catch (Throwable unused2) {
                    Logger.e(TAG, "the thread submit has fatal error!");
                }
            } else if (eventsToReport.size() > 10) {
                Logger.e("TAG", "the event to be report when init exceed the limit!");
            } else {
                eventsToReport.add(runnable);
            }
        }
    }

    public static void submitAllEvents() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            try {
                for (Runnable runnable : eventsToReport) {
                    HianalyticsHelper.getInstance().getReportExecutor().submit(runnable);
                }
                eventsToReport.clear();
            } catch (NullPointerException unused) {
                Logger.e(TAG, "event is null occured");
            } catch (RejectedExecutionException unused2) {
                Logger.e(TAG, "submit failed of rejected execution exception");
            } catch (Exception unused3) {
                Logger.e(TAG, "submit failed because of some exception");
            }
        }
    }
}
