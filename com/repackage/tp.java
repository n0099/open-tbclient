package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.ctrl.model.TaskEnvTag;
import com.baidu.bdtask.ctrl.model.TaskProcess;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.ctrl.model.TaskStatusRuntime;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class tp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public tp() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, sq sqVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, sqVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c != null) {
                c.processRuleDataMaxValueFix();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null && (taskStatus = c2.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(sqVar);
            }
            return bVar2;
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }

    public final com.baidu.bdtask.ctrl.b b(com.baidu.bdtask.ctrl.b bVar, String str) {
        InterceptResult invokeLL;
        SubTaskState k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str)) == null) {
            TaskInfo f = bVar.f(str);
            if (f != null && !jv.a.c(f.getTaskRule().getExpireTime()) && (k = bVar.k(str)) != null) {
                k.updateStatus(22, 103, "task is expired");
                k.getTaskStatus().clearProcess();
            }
            return bVar;
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }

    public final com.baidu.bdtask.ctrl.b c(sq sqVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, sqVar, bVar)) == null) {
            if (Intrinsics.areEqual(sqVar, (dq) (!(sqVar instanceof dq) ? null : sqVar))) {
                com.baidu.bdtask.ctrl.b a = a(bVar, sqVar);
                dq dqVar = (dq) sqVar;
                a.h(dqVar.h());
                a.i(dqVar.h(), dqVar.i());
                SubTaskState k = a.k(dqVar.f());
                if (k != null) {
                    k.setInterceptor(dqVar.j());
                    k.updateStatus(dqVar.g(), Integer.valueOf(dqVar.a()), dqVar.d());
                }
                b(a, dqVar.f());
                return a;
            }
            if (Intrinsics.areEqual(sqVar, (vp) (!(sqVar instanceof vp) ? null : sqVar))) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, sqVar);
                vp vpVar = (vp) sqVar;
                SubTaskState k2 = a2.k(vpVar.f());
                if (k2 != null) {
                    k2.updateStatus(vpVar.g(), Integer.valueOf(vpVar.a()), vpVar.d());
                    k2.updateExtraUnRegisterMsg(vpVar.h());
                }
                return a2;
            }
            if (Intrinsics.areEqual(sqVar, (cq) (!(sqVar instanceof cq) ? null : sqVar))) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, sqVar);
                cq cqVar = (cq) sqVar;
                SubTaskState k3 = a3.k(cqVar.f());
                if (k3 != null) {
                    k3.updateStatus(cqVar.g(), Integer.valueOf(cqVar.a()), cqVar.d()).getTaskStatus().setInterruptErrorNo(cqVar.h());
                    k3.clearProcess();
                    k3.cleanDuplicateId();
                }
                return a3;
            }
            if (Intrinsics.areEqual(sqVar, (up) (!(sqVar instanceof up) ? null : sqVar))) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, sqVar);
                up upVar = (up) sqVar;
                SubTaskState k4 = a4.k(upVar.f());
                if (k4 != null) {
                    k4.updateStatus(upVar.g(), Integer.valueOf(upVar.a()), upVar.d());
                    k4.reset2Running(k4.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (Intrinsics.areEqual(sqVar, (wp) (!(sqVar instanceof wp) ? null : sqVar))) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, sqVar);
                wp wpVar = (wp) sqVar;
                SubTaskState k5 = a5.k(wpVar.f());
                if (k5 != null) {
                    k5.updateStatus(wpVar.g(), Integer.valueOf(wpVar.a()), wpVar.d());
                    TaskProcess process = k5.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(wpVar.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, wpVar.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k5.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(wpVar.h());
                    }
                }
                b(a5, wpVar.f());
                return a5;
            }
            if (Intrinsics.areEqual(sqVar, (xp) (!(sqVar instanceof xp) ? null : sqVar))) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, sqVar);
                xp xpVar = (xp) sqVar;
                SubTaskState k6 = a6.k(xpVar.f());
                if (k6 != null) {
                    k6.updateStatus(xpVar.g(), Integer.valueOf(xpVar.a()), xpVar.d());
                    TaskStatus taskStatus = k6.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(xpVar.h());
                    if (!TextUtils.isEmpty(xpVar.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, xpVar.j(), xpVar.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(xpVar.i());
                }
                b(a6, xpVar.f());
                return a6;
            }
            if (Intrinsics.areEqual(sqVar, (bq) (!(sqVar instanceof bq) ? null : sqVar))) {
                bq bqVar = (bq) sqVar;
                TaskInfo k7 = bqVar.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, sqVar);
                SubTaskState k8 = a7.k(bqVar.f());
                if (k8 != null) {
                    if (cv.a.a(bqVar.a()) && k8.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k8.updateStatus(bqVar.i(), 0, "");
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k8.updateStatus(bqVar.i(), Integer.valueOf(bqVar.a()), bqVar.d());
                        k8.updateTaskInfoByMerge(k7);
                        k8.updateTaskInfoWithResponse(bqVar.j());
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k8.getTaskInfo().getTaskRule().isNeedUnique() && k8.getTaskInfo().isVisitAction()) {
                            k8.getTaskStatus().getProcess().cacheDuplicateId(bqVar.l());
                        }
                        k8.clearProcessTags();
                        k8.addExitOnce();
                    }
                }
                b(a7, bqVar.f());
                return a7;
            }
            if (Intrinsics.areEqual(sqVar, (zp) (!(sqVar instanceof zp) ? null : sqVar))) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, sqVar);
                zp zpVar = (zp) sqVar;
                SubTaskState k9 = a8.k(zpVar.f());
                if (k9 != null) {
                    k9.updateStatus(zpVar.g(), Integer.valueOf(zpVar.a()), zpVar.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (Intrinsics.areEqual(sqVar, (aq) (!(sqVar instanceof aq) ? null : sqVar))) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, sqVar);
                SubTaskState k10 = a9.k(((aq) sqVar).f());
                if (k10 != null) {
                    k10.resetExit();
                }
                return a9;
            }
            if (Intrinsics.areEqual(sqVar, sqVar instanceof yp ? sqVar : null)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, sqVar);
                yp ypVar = (yp) sqVar;
                SubTaskState k11 = a10.k(ypVar.f());
                if (k11 != null && k11.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(ypVar.g())) {
                    k11.getTaskStatus().getProcess().cacheDuplicateId(ypVar.g());
                }
                return a10;
            }
            return a(bVar, sqVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
