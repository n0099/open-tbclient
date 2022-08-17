package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.VoiceRoom;
/* loaded from: classes7.dex */
public class os6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<ks6> a(List<VoiceRoom> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (VoiceRoom voiceRoom : list) {
                if (voiceRoom != null) {
                    ArrayList arrayList2 = new ArrayList();
                    ks6 ks6Var = new ks6();
                    ks6Var.a = voiceRoom.room_name;
                    ks6Var.c = String.valueOf(voiceRoom.talker_num);
                    ks6Var.d = String.valueOf(voiceRoom.joined_num);
                    ks6Var.e = voiceRoom.room_id.longValue();
                    for (User user : voiceRoom.talker) {
                        if (user != null) {
                            arrayList2.add(user.portrait);
                        }
                    }
                    ks6Var.b = arrayList2;
                    arrayList.add(ks6Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
