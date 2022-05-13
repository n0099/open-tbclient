package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.model.TaskEnvTag;
import com.baidu.bdtask.ctrl.model.TaskProcess;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.ctrl.model.TaskStatusRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class tu extends su<TaskStatus> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tu(uu uuVar) {
        super(uuVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uuVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((uu) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TaskStatus.key : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.su
    /* renamed from: c */
    public TaskStatus a(String str) {
        InterceptResult invokeL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i = jSONObject.getInt(TaskStatus.keyCurStatus);
                int i2 = jSONObject.getInt(TaskStatus.keyCurStatusCode);
                String curStatusCodeMsg = jSONObject.getString(TaskStatus.keyCurStatusCodeMsg);
                int i3 = jSONObject.getInt(TaskStatus.keyInterruptErrorNo);
                long j2 = jSONObject.getLong(TaskStatus.keyCurActiveTime);
                JSONObject jSONObject2 = jSONObject.getJSONObject("process");
                int i4 = jSONObject2.getInt(TaskProcess.keyClickNumber);
                long j3 = jSONObject2.getLong(TaskProcess.keyStayDurTimeMs);
                long j4 = jSONObject2.getLong(TaskProcess.keyMaxStayTime);
                int i5 = jSONObject2.getInt(TaskProcess.keyMaxRepeatTimes);
                int i6 = jSONObject2.getInt(TaskProcess.keyMaxNoClickTimes);
                int i7 = jSONObject2.getInt(TaskProcess.keyCurNoClickTimes);
                JSONArray optJSONArray = jSONObject2.optJSONArray(TaskProcess.keyDuplicateIds);
                HashSet hashSet = new HashSet();
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    j = j2;
                    for (int i8 = 0; i8 < length; i8++) {
                        hashSet.add(optJSONArray.optString(i8));
                    }
                } else {
                    j = j2;
                }
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("tags");
                HashSet hashSet2 = new HashSet();
                if (optJSONArray2 != null) {
                    int length2 = optJSONArray2.length();
                    int i9 = 0;
                    while (i9 < length2) {
                        int i10 = length2;
                        TaskEnvTag b = TaskEnvTag.Companion.b(optJSONArray2.optString(i9));
                        if (b != null) {
                            hashSet2.add(b);
                        }
                        i9++;
                        length2 = i10;
                    }
                }
                Intrinsics.checkExpressionValueIsNotNull(curStatusCodeMsg, "curStatusCodeMsg");
                return new TaskStatus(i, i2, curStatusCodeMsg, i3, j, TaskStatusRuntime.Companion.a(), new TaskProcess(i4, j3, i7, j4, i5, i6, hashSet2, hashSet));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (TaskStatus) invokeL.objValue;
    }
}
