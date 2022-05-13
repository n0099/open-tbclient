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
/* loaded from: classes6.dex */
public final class gr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public gr() {
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

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, fs fsVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, fsVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c != null) {
                c.processRuleDataMaxValueFix();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null && (taskStatus = c2.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(fsVar);
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
            if (f != null && !ww.a.c(f.getTaskRule().getExpireTime()) && (k = bVar.k(str)) != null) {
                k.updateStatus(22, 103, "task is expired");
                k.getTaskStatus().clearProcess();
            }
            return bVar;
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }

    public final com.baidu.bdtask.ctrl.b c(fs fsVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fsVar, bVar)) == null) {
            if (Intrinsics.areEqual(fsVar, (qr) (!(fsVar instanceof qr) ? null : fsVar))) {
                com.baidu.bdtask.ctrl.b a = a(bVar, fsVar);
                qr qrVar = (qr) fsVar;
                a.h(qrVar.h());
                a.i(qrVar.h(), qrVar.i());
                SubTaskState k = a.k(qrVar.f());
                if (k != null) {
                    k.setInterceptor(qrVar.j());
                    k.updateStatus(qrVar.g(), Integer.valueOf(qrVar.a()), qrVar.d());
                }
                b(a, qrVar.f());
                return a;
            }
            if (Intrinsics.areEqual(fsVar, (ir) (!(fsVar instanceof ir) ? null : fsVar))) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, fsVar);
                ir irVar = (ir) fsVar;
                SubTaskState k2 = a2.k(irVar.f());
                if (k2 != null) {
                    k2.updateStatus(irVar.g(), Integer.valueOf(irVar.a()), irVar.d());
                    k2.updateExtraUnRegisterMsg(irVar.h());
                }
                return a2;
            }
            if (Intrinsics.areEqual(fsVar, (pr) (!(fsVar instanceof pr) ? null : fsVar))) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, fsVar);
                pr prVar = (pr) fsVar;
                SubTaskState k3 = a3.k(prVar.f());
                if (k3 != null) {
                    k3.updateStatus(prVar.g(), Integer.valueOf(prVar.a()), prVar.d()).getTaskStatus().setInterruptErrorNo(prVar.h());
                    k3.clearProcess();
                    k3.cleanDuplicateId();
                }
                return a3;
            }
            if (Intrinsics.areEqual(fsVar, (hr) (!(fsVar instanceof hr) ? null : fsVar))) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, fsVar);
                hr hrVar = (hr) fsVar;
                SubTaskState k4 = a4.k(hrVar.f());
                if (k4 != null) {
                    k4.updateStatus(hrVar.g(), Integer.valueOf(hrVar.a()), hrVar.d());
                    k4.reset2Running(k4.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (Intrinsics.areEqual(fsVar, (jr) (!(fsVar instanceof jr) ? null : fsVar))) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, fsVar);
                jr jrVar = (jr) fsVar;
                SubTaskState k5 = a5.k(jrVar.f());
                if (k5 != null) {
                    k5.updateStatus(jrVar.g(), Integer.valueOf(jrVar.a()), jrVar.d());
                    TaskProcess process = k5.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(jrVar.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, jrVar.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k5.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(jrVar.h());
                    }
                }
                b(a5, jrVar.f());
                return a5;
            }
            if (Intrinsics.areEqual(fsVar, (kr) (!(fsVar instanceof kr) ? null : fsVar))) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, fsVar);
                kr krVar = (kr) fsVar;
                SubTaskState k6 = a6.k(krVar.f());
                if (k6 != null) {
                    k6.updateStatus(krVar.g(), Integer.valueOf(krVar.a()), krVar.d());
                    TaskStatus taskStatus = k6.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(krVar.h());
                    if (!TextUtils.isEmpty(krVar.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, krVar.j(), krVar.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(krVar.i());
                }
                b(a6, krVar.f());
                return a6;
            }
            if (Intrinsics.areEqual(fsVar, (or) (!(fsVar instanceof or) ? null : fsVar))) {
                or orVar = (or) fsVar;
                TaskInfo k7 = orVar.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, fsVar);
                SubTaskState k8 = a7.k(orVar.f());
                if (k8 != null) {
                    if (pw.a.a(orVar.a()) && k8.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k8.updateStatus(orVar.i(), 0, "");
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k8.updateStatus(orVar.i(), Integer.valueOf(orVar.a()), orVar.d());
                        k8.updateTaskInfoByMerge(k7);
                        k8.updateTaskInfoWithResponse(orVar.j());
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k8.getTaskInfo().getTaskRule().isNeedUnique() && k8.getTaskInfo().isVisitAction()) {
                            k8.getTaskStatus().getProcess().cacheDuplicateId(orVar.l());
                        }
                        k8.clearProcessTags();
                        k8.addExitOnce();
                    }
                }
                b(a7, orVar.f());
                return a7;
            }
            if (Intrinsics.areEqual(fsVar, (mr) (!(fsVar instanceof mr) ? null : fsVar))) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, fsVar);
                mr mrVar = (mr) fsVar;
                SubTaskState k9 = a8.k(mrVar.f());
                if (k9 != null) {
                    k9.updateStatus(mrVar.g(), Integer.valueOf(mrVar.a()), mrVar.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (Intrinsics.areEqual(fsVar, (nr) (!(fsVar instanceof nr) ? null : fsVar))) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, fsVar);
                SubTaskState k10 = a9.k(((nr) fsVar).f());
                if (k10 != null) {
                    k10.resetExit();
                }
                return a9;
            }
            if (Intrinsics.areEqual(fsVar, fsVar instanceof lr ? fsVar : null)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, fsVar);
                lr lrVar = (lr) fsVar;
                SubTaskState k11 = a10.k(lrVar.f());
                if (k11 != null && k11.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(lrVar.g())) {
                    k11.getTaskStatus().getProcess().cacheDuplicateId(lrVar.g());
                }
                return a10;
            }
            return a(bVar, fsVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
