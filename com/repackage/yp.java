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
public final class yp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public yp() {
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

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, xq xqVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, xqVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c != null) {
                c.processRuleDataMaxValueFix();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null && (taskStatus = c2.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(xqVar);
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
            if (f != null && !ov.a.c(f.getTaskRule().getExpireTime()) && (k = bVar.k(str)) != null) {
                k.updateStatus(22, 103, "task is expired");
                k.getTaskStatus().clearProcess();
            }
            return bVar;
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }

    public final com.baidu.bdtask.ctrl.b c(xq xqVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, xqVar, bVar)) == null) {
            if (Intrinsics.areEqual(xqVar, (iq) (!(xqVar instanceof iq) ? null : xqVar))) {
                com.baidu.bdtask.ctrl.b a = a(bVar, xqVar);
                iq iqVar = (iq) xqVar;
                a.h(iqVar.h());
                a.i(iqVar.h(), iqVar.i());
                SubTaskState k = a.k(iqVar.f());
                if (k != null) {
                    k.setInterceptor(iqVar.j());
                    k.updateStatus(iqVar.g(), Integer.valueOf(iqVar.a()), iqVar.d());
                }
                b(a, iqVar.f());
                return a;
            }
            if (Intrinsics.areEqual(xqVar, (aq) (!(xqVar instanceof aq) ? null : xqVar))) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, xqVar);
                aq aqVar = (aq) xqVar;
                SubTaskState k2 = a2.k(aqVar.f());
                if (k2 != null) {
                    k2.updateStatus(aqVar.g(), Integer.valueOf(aqVar.a()), aqVar.d());
                    k2.updateExtraUnRegisterMsg(aqVar.h());
                }
                return a2;
            }
            if (Intrinsics.areEqual(xqVar, (hq) (!(xqVar instanceof hq) ? null : xqVar))) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, xqVar);
                hq hqVar = (hq) xqVar;
                SubTaskState k3 = a3.k(hqVar.f());
                if (k3 != null) {
                    k3.updateStatus(hqVar.g(), Integer.valueOf(hqVar.a()), hqVar.d()).getTaskStatus().setInterruptErrorNo(hqVar.h());
                    k3.clearProcess();
                    k3.cleanDuplicateId();
                }
                return a3;
            }
            if (Intrinsics.areEqual(xqVar, (zp) (!(xqVar instanceof zp) ? null : xqVar))) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, xqVar);
                zp zpVar = (zp) xqVar;
                SubTaskState k4 = a4.k(zpVar.f());
                if (k4 != null) {
                    k4.updateStatus(zpVar.g(), Integer.valueOf(zpVar.a()), zpVar.d());
                    k4.reset2Running(k4.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (Intrinsics.areEqual(xqVar, (bq) (!(xqVar instanceof bq) ? null : xqVar))) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, xqVar);
                bq bqVar = (bq) xqVar;
                SubTaskState k5 = a5.k(bqVar.f());
                if (k5 != null) {
                    k5.updateStatus(bqVar.g(), Integer.valueOf(bqVar.a()), bqVar.d());
                    TaskProcess process = k5.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(bqVar.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, bqVar.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k5.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(bqVar.h());
                    }
                }
                b(a5, bqVar.f());
                return a5;
            }
            if (Intrinsics.areEqual(xqVar, (cq) (!(xqVar instanceof cq) ? null : xqVar))) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, xqVar);
                cq cqVar = (cq) xqVar;
                SubTaskState k6 = a6.k(cqVar.f());
                if (k6 != null) {
                    k6.updateStatus(cqVar.g(), Integer.valueOf(cqVar.a()), cqVar.d());
                    TaskStatus taskStatus = k6.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(cqVar.h());
                    if (!TextUtils.isEmpty(cqVar.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, cqVar.j(), cqVar.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(cqVar.i());
                }
                b(a6, cqVar.f());
                return a6;
            }
            if (Intrinsics.areEqual(xqVar, (gq) (!(xqVar instanceof gq) ? null : xqVar))) {
                gq gqVar = (gq) xqVar;
                TaskInfo k7 = gqVar.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, xqVar);
                SubTaskState k8 = a7.k(gqVar.f());
                if (k8 != null) {
                    if (hv.a.a(gqVar.a()) && k8.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k8.updateStatus(gqVar.i(), 0, "");
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k8.updateStatus(gqVar.i(), Integer.valueOf(gqVar.a()), gqVar.d());
                        k8.updateTaskInfoByMerge(k7);
                        k8.updateTaskInfoWithResponse(gqVar.j());
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k8.getTaskInfo().getTaskRule().isNeedUnique() && k8.getTaskInfo().isVisitAction()) {
                            k8.getTaskStatus().getProcess().cacheDuplicateId(gqVar.l());
                        }
                        k8.clearProcessTags();
                        k8.addExitOnce();
                    }
                }
                b(a7, gqVar.f());
                return a7;
            }
            if (Intrinsics.areEqual(xqVar, (eq) (!(xqVar instanceof eq) ? null : xqVar))) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, xqVar);
                eq eqVar = (eq) xqVar;
                SubTaskState k9 = a8.k(eqVar.f());
                if (k9 != null) {
                    k9.updateStatus(eqVar.g(), Integer.valueOf(eqVar.a()), eqVar.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (Intrinsics.areEqual(xqVar, (fq) (!(xqVar instanceof fq) ? null : xqVar))) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, xqVar);
                SubTaskState k10 = a9.k(((fq) xqVar).f());
                if (k10 != null) {
                    k10.resetExit();
                }
                return a9;
            }
            if (Intrinsics.areEqual(xqVar, xqVar instanceof dq ? xqVar : null)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, xqVar);
                dq dqVar = (dq) xqVar;
                SubTaskState k11 = a10.k(dqVar.f());
                if (k11 != null && k11.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(dqVar.g())) {
                    k11.getTaskStatus().getProcess().cacheDuplicateId(dqVar.g());
                }
                return a10;
            }
            return a(bVar, xqVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
