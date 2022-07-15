package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.VoiceRoom;
/* loaded from: classes7.dex */
public class wq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<sq6> a(List<VoiceRoom> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (VoiceRoom voiceRoom : list) {
                if (voiceRoom != null) {
                    ArrayList arrayList2 = new ArrayList();
                    sq6 sq6Var = new sq6();
                    sq6Var.a = voiceRoom.room_name;
                    sq6Var.c = String.valueOf(voiceRoom.talker_num);
                    sq6Var.d = String.valueOf(voiceRoom.joined_num);
                    sq6Var.e = voiceRoom.room_id.longValue();
                    for (User user : voiceRoom.talker) {
                        if (user != null) {
                            arrayList2.add(user.portrait);
                        }
                    }
                    sq6Var.b = arrayList2;
                    arrayList.add(sq6Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
