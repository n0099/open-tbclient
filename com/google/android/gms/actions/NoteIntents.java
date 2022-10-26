package com.google.android.gms.actions;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class NoteIntents {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_APPEND_NOTE = "com.google.android.gms.actions.APPEND_NOTE";
    public static final String ACTION_CREATE_NOTE = "com.google.android.gms.actions.CREATE_NOTE";
    public static final String ACTION_DELETE_NOTE = "com.google.android.gms.actions.DELETE_NOTE";
    public static final String EXTRA_NAME = "com.google.android.gms.actions.extra.NAME";
    public static final String EXTRA_NOTE_QUERY = "com.google.android.gms.actions.extra.NOTE_QUERY";
    public static final String EXTRA_TEXT = "com.google.android.gms.actions.extra.TEXT";
    public transient /* synthetic */ FieldHolder $fh;

    public NoteIntents() {
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
}
