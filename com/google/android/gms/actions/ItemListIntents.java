package com.google.android.gms.actions;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ItemListIntents {
    public static /* synthetic */ Interceptable $ic = null;
    @NonNull
    public static final String ACTION_ACCEPT_ITEM = "com.google.android.gms.actions.ACCEPT_ITEM";
    @NonNull
    public static final String ACTION_APPEND_ITEM_LIST = "com.google.android.gms.actions.APPEND_ITEM_LIST";
    @NonNull
    public static final String ACTION_CREATE_ITEM_LIST = "com.google.android.gms.actions.CREATE_ITEM_LIST";
    @NonNull
    public static final String ACTION_DELETE_ITEM = "com.google.android.gms.actions.DELETE_ITEM";
    @NonNull
    public static final String ACTION_DELETE_ITEM_LIST = "com.google.android.gms.actions.DELETE_ITEM_LIST";
    @NonNull
    public static final String ACTION_REJECT_ITEM = "com.google.android.gms.actions.REJECT_ITEM";
    @NonNull
    public static final String EXTRA_ITEM_NAME = "com.google.android.gms.actions.extra.ITEM_NAME";
    @NonNull
    public static final String EXTRA_ITEM_NAMES = "com.google.android.gms.actions.extra.ITEM_NAMES";
    @NonNull
    public static final String EXTRA_ITEM_QUERY = "com.google.android.gms.actions.extra.ITEM_QUERY";
    @NonNull
    public static final String EXTRA_LIST_NAME = "com.google.android.gms.actions.extra.LIST_NAME";
    @NonNull
    public static final String EXTRA_LIST_QUERY = "com.google.android.gms.actions.extra.LIST_QUERY";
    public transient /* synthetic */ FieldHolder $fh;

    public ItemListIntents() {
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
