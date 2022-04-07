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
public final class xr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xr() {
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

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, ws wsVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, wsVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c != null) {
                c.processRuleDataMaxValueFix();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null && (taskStatus = c2.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(wsVar);
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
            if (f != null && !nx.a.c(f.getTaskRule().getExpireTime()) && (k = bVar.k(str)) != null) {
                k.updateStatus(22, 103, "task is expired");
                k.getTaskStatus().clearProcess();
            }
            return bVar;
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }

    public final com.baidu.bdtask.ctrl.b c(ws wsVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, wsVar, bVar)) == null) {
            if (Intrinsics.areEqual(wsVar, (hs) (!(wsVar instanceof hs) ? null : wsVar))) {
                com.baidu.bdtask.ctrl.b a = a(bVar, wsVar);
                hs hsVar = (hs) wsVar;
                a.h(hsVar.h());
                a.i(hsVar.h(), hsVar.i());
                SubTaskState k = a.k(hsVar.f());
                if (k != null) {
                    k.setInterceptor(hsVar.j());
                    k.updateStatus(hsVar.g(), Integer.valueOf(hsVar.a()), hsVar.d());
                }
                b(a, hsVar.f());
                return a;
            }
            if (Intrinsics.areEqual(wsVar, (zr) (!(wsVar instanceof zr) ? null : wsVar))) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, wsVar);
                zr zrVar = (zr) wsVar;
                SubTaskState k2 = a2.k(zrVar.f());
                if (k2 != null) {
                    k2.updateStatus(zrVar.g(), Integer.valueOf(zrVar.a()), zrVar.d());
                    k2.updateExtraUnRegisterMsg(zrVar.h());
                }
                return a2;
            }
            if (Intrinsics.areEqual(wsVar, (gs) (!(wsVar instanceof gs) ? null : wsVar))) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, wsVar);
                gs gsVar = (gs) wsVar;
                SubTaskState k3 = a3.k(gsVar.f());
                if (k3 != null) {
                    k3.updateStatus(gsVar.g(), Integer.valueOf(gsVar.a()), gsVar.d()).getTaskStatus().setInterruptErrorNo(gsVar.h());
                    k3.clearProcess();
                    k3.cleanDuplicateId();
                }
                return a3;
            }
            if (Intrinsics.areEqual(wsVar, (yr) (!(wsVar instanceof yr) ? null : wsVar))) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, wsVar);
                yr yrVar = (yr) wsVar;
                SubTaskState k4 = a4.k(yrVar.f());
                if (k4 != null) {
                    k4.updateStatus(yrVar.g(), Integer.valueOf(yrVar.a()), yrVar.d());
                    k4.reset2Running(k4.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (Intrinsics.areEqual(wsVar, (as) (!(wsVar instanceof as) ? null : wsVar))) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, wsVar);
                as asVar = (as) wsVar;
                SubTaskState k5 = a5.k(asVar.f());
                if (k5 != null) {
                    k5.updateStatus(asVar.g(), Integer.valueOf(asVar.a()), asVar.d());
                    TaskProcess process = k5.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(asVar.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, asVar.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k5.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(asVar.h());
                    }
                }
                b(a5, asVar.f());
                return a5;
            }
            if (Intrinsics.areEqual(wsVar, (bs) (!(wsVar instanceof bs) ? null : wsVar))) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, wsVar);
                bs bsVar = (bs) wsVar;
                SubTaskState k6 = a6.k(bsVar.f());
                if (k6 != null) {
                    k6.updateStatus(bsVar.g(), Integer.valueOf(bsVar.a()), bsVar.d());
                    TaskStatus taskStatus = k6.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(bsVar.h());
                    if (!TextUtils.isEmpty(bsVar.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, bsVar.j(), bsVar.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(bsVar.i());
                }
                b(a6, bsVar.f());
                return a6;
            }
            if (Intrinsics.areEqual(wsVar, (fs) (!(wsVar instanceof fs) ? null : wsVar))) {
                fs fsVar = (fs) wsVar;
                TaskInfo k7 = fsVar.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, wsVar);
                SubTaskState k8 = a7.k(fsVar.f());
                if (k8 != null) {
                    if (gx.a.a(fsVar.a()) && k8.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k8.updateStatus(fsVar.i(), 0, "");
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k8.updateStatus(fsVar.i(), Integer.valueOf(fsVar.a()), fsVar.d());
                        k8.updateTaskInfoByMerge(k7);
                        k8.updateTaskInfoWithResponse(fsVar.j());
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k8.getTaskInfo().getTaskRule().isNeedUnique() && k8.getTaskInfo().isVisitAction()) {
                            k8.getTaskStatus().getProcess().cacheDuplicateId(fsVar.l());
                        }
                        k8.clearProcessTags();
                        k8.addExitOnce();
                    }
                }
                b(a7, fsVar.f());
                return a7;
            }
            if (Intrinsics.areEqual(wsVar, (ds) (!(wsVar instanceof ds) ? null : wsVar))) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, wsVar);
                ds dsVar = (ds) wsVar;
                SubTaskState k9 = a8.k(dsVar.f());
                if (k9 != null) {
                    k9.updateStatus(dsVar.g(), Integer.valueOf(dsVar.a()), dsVar.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (Intrinsics.areEqual(wsVar, (es) (!(wsVar instanceof es) ? null : wsVar))) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, wsVar);
                SubTaskState k10 = a9.k(((es) wsVar).f());
                if (k10 != null) {
                    k10.resetExit();
                }
                return a9;
            }
            if (Intrinsics.areEqual(wsVar, wsVar instanceof cs ? wsVar : null)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, wsVar);
                cs csVar = (cs) wsVar;
                SubTaskState k11 = a10.k(csVar.f());
                if (k11 != null && k11.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(csVar.g())) {
                    k11.getTaskStatus().getProcess().cacheDuplicateId(csVar.g());
                }
                return a10;
            }
            return a(bVar, wsVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
