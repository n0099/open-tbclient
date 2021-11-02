package com.dxmpay.wallet.base.datamodel;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.wallet.core.NoProguard;
import java.io.Serializable;
import java.math.BigDecimal;
/* loaded from: classes11.dex */
public class UserData implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public static class FingerprintAuthInfo implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String uafRequest;

        public FingerprintAuthInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class Misc implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 993460856554011232L;
        public transient /* synthetic */ FieldHolder $fh;
        public ConfirmButtonMsg msg_pay_btn;
        public String no_mobilepwd_msg;
        public String nopass_msg;
        public String title_url;
        public String trans_need_to_pay;

        /* loaded from: classes11.dex */
        public static class ConfirmButtonMsg implements NoProguard, Serializable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String default_msg;
            public String new_card;
            public String nopass;
            public String transfer2card;

            public ConfirmButtonMsg() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public String getDefault_msg() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.default_msg : (String) invokeV.objValue;
            }

            public String getNew_card() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.new_card : (String) invokeV.objValue;
            }

            public String getNopass() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.nopass : (String) invokeV.objValue;
            }
        }

        public Misc() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String getInsideTransOrder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.trans_need_to_pay : (String) invokeV.objValue;
        }

        public ConfirmButtonMsg getPayButtonMsg() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.msg_pay_btn : (ConfirmButtonMsg) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class SP implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 993460856554011232L;
        public transient /* synthetic */ FieldHolder $fh;
        public String goods_name;
        public String seller_user_id;
        public String serial_num;
        public String session_no;
        public String sp_company;
        public String sp_no;

        public SP() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String getSellerUserId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.seller_user_id : (String) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "[sp_company=" + this.sp_company + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class UserModel implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String STATUS_LOGINED = "1";
        public static final long serialVersionUID = -1273103909085078415L;
        public transient /* synthetic */ FieldHolder $fh;
        public Account account;
        public int auth_status;
        public String authorize_display_name;
        public int balance_pay_status;
        public String balance_support_status;
        public String balance_unsupport_reason;
        public String can_use_pcpwd_verify;
        public String certificate_code;
        public String certificate_code_ec;
        public String certificate_type;
        public DisplayFlag display_flag;
        public String display_name;
        public String enable_fingerprint;
        public FingerprintAuthInfo fingerprint_auth_info;
        public FingerprintMsg fingerprint_msg;
        public String guide_to_open_fingerprint;
        public int has_mobile_password;
        public int is_authed;
        public String is_login;
        public int is_repaired;
        public String last3_paytype;
        public String login_name;
        public String mobile;
        public String mobile_ec;
        public String mobile_number;
        public String need_pay_password;
        public String passfree_msg;
        public PassFreeProtocol passfree_protocol;
        public String passfree_selected;
        public int pwd_left_count;
        public Score score;
        public int stark_account_level;
        public String stark_auth_msg;
        public String stark_balance_msg;
        public String true_name;
        public String user_id;

        /* loaded from: classes11.dex */
        public static class Account implements Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 2427773423716342178L;
            public transient /* synthetic */ FieldHolder $fh;
            public String available_withdraw_amount;
            public String balance_amount;
            public String can_amount;
            public String can_amount3;
            public String freeze_amount;
            public String recv_amount;
            public String recv_create_time;
            public String recv_info;
            public String return_cash_content;
            public String return_cash_url;
            public String virtual_amount;

            public Account() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.return_cash_content = "";
                this.return_cash_url = "";
            }

            public String getCanAmount() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.can_amount) ? this.can_amount : "0" : (String) invokeV.objValue;
            }

            public boolean hasCanAmount() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (TextUtils.isEmpty(this.can_amount)) {
                        return false;
                    }
                    try {
                        return new BigDecimal(this.can_amount).compareTo(BigDecimal.ZERO) > 0;
                    } catch (Exception unused) {
                        return false;
                    }
                }
                return invokeV.booleanValue;
            }

            /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
                java.lang.NullPointerException: Cannot read field "wordsInUse" because "set" is null
                	at java.base/java.util.BitSet.or(BitSet.java:943)
                	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:732)
                	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:811)
                	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:88)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:706)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
                	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
                */
            public boolean isBalanceEnough(java.lang.String r5) {
                /*
                    r4 = this;
                    com.baidu.titan.sdk.runtime.Interceptable r0 = com.dxmpay.wallet.base.datamodel.UserData.UserModel.Account.$ic
                    if (r0 != 0) goto L28
                L4:
                    java.lang.String r0 = r4.can_amount
                    boolean r0 = android.text.TextUtils.isEmpty(r0)
                    r1 = 0
                    if (r0 != 0) goto L27
                    boolean r0 = android.text.TextUtils.isEmpty(r5)
                    if (r0 == 0) goto L14
                    goto L27
                L14:
                    java.math.BigDecimal r0 = new java.math.BigDecimal     // Catch: java.lang.Exception -> L27
                    java.lang.String r2 = r4.can_amount     // Catch: java.lang.Exception -> L27
                    r0.<init>(r2)     // Catch: java.lang.Exception -> L27
                    java.math.BigDecimal r2 = new java.math.BigDecimal     // Catch: java.lang.Exception -> L27
                    r2.<init>(r5)     // Catch: java.lang.Exception -> L27
                    int r5 = r0.compareTo(r2)     // Catch: java.lang.Exception -> L27
                    if (r5 < 0) goto L27
                    r1 = 1
                L27:
                    return r1
                L28:
                    r2 = r0
                    r3 = 1048578(0x100002, float:1.469371E-39)
                    com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeL(r3, r4, r5)
                    if (r0 == 0) goto L4
                    boolean r1 = r0.booleanValue
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.wallet.base.datamodel.UserData.UserModel.Account.isBalanceEnough(java.lang.String):boolean");
            }

            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                    return "钱包余额信息-->[balance_amount:" + this.balance_amount + "&freeze_amount:" + this.freeze_amount + "&virtual_amount:" + this.virtual_amount + "&can_amount:" + this.can_amount + "&available_withdraw_amount:" + this.available_withdraw_amount + PreferencesUtil.RIGHT_MOUNT;
                }
                return (String) invokeV.objValue;
            }
        }

        /* loaded from: classes11.dex */
        public static class DisplayFlag implements Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final String NOT_SHOW = "1";
            public static final String SHOW_AND_WRITE = "3";
            public static final String SHOW_NOT_WRITE = "2";
            public static final long serialVersionUID = -6111380299465016961L;
            public transient /* synthetic */ FieldHolder $fh;
            public String certificate_code;
            public String certificate_type;
            public String mobile;
            public String true_name;

            public DisplayFlag() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.true_name = "";
                this.mobile = "";
                this.certificate_code = "";
                this.certificate_type = "";
            }

            public String getCodeFlag() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.certificate_code : (String) invokeV.objValue;
            }

            public String getMobileFlag() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mobile : (String) invokeV.objValue;
            }

            public String getNameFlag() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.true_name : (String) invokeV.objValue;
            }
        }

        /* loaded from: classes11.dex */
        public static class FingerprintMsg implements NoProguard, Serializable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public Open open;
            public Reopen reopen;
            public Update update;

            /* loaded from: classes11.dex */
            public static class Open implements NoProguard, Serializable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public FingerprintProtocol fingerprint_protocol;
                public String[] hints;
                public String subtitle;
                public String title;

                /* loaded from: classes11.dex */
                public static class FingerprintProtocol implements NoProguard, Serializable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public String fingerprint_protocol_msg;
                    public String fingerprint_protocol_prefix;
                    public String fingerprint_protocol_url;

                    public FingerprintProtocol() {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    public String getFingerprintProtocolMsg() {
                        InterceptResult invokeV;
                        Interceptable interceptable = $ic;
                        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.fingerprint_protocol_msg : (String) invokeV.objValue;
                    }

                    public String getFingerprintProtocolPrefix() {
                        InterceptResult invokeV;
                        Interceptable interceptable = $ic;
                        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.fingerprint_protocol_prefix : (String) invokeV.objValue;
                    }

                    public String getFingerprintProtocolUrl() {
                        InterceptResult invokeV;
                        Interceptable interceptable = $ic;
                        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.fingerprint_protocol_url : (String) invokeV.objValue;
                    }
                }

                public Open() {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                public FingerprintProtocol getFingerprintProtocol() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.fingerprint_protocol : (FingerprintProtocol) invokeV.objValue;
                }

                public String[] getHints() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.hints : (String[]) invokeV.objValue;
                }

                public String getSubtitle() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.subtitle : (String) invokeV.objValue;
                }

                public String getTitle() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.title : (String) invokeV.objValue;
                }
            }

            /* loaded from: classes11.dex */
            public static class Reopen implements NoProguard, Serializable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public FingerprintProtocol fingerprint_protocol;
                public String subtitle;
                public String title;

                /* loaded from: classes11.dex */
                public static class FingerprintProtocol implements NoProguard, Serializable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public String fingerprint_protocol_msg;
                    public String fingerprint_protocol_prefix;
                    public String fingerprint_protocol_url;

                    public FingerprintProtocol() {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    public String getFingerprintProtocolMsg() {
                        InterceptResult invokeV;
                        Interceptable interceptable = $ic;
                        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.fingerprint_protocol_msg : (String) invokeV.objValue;
                    }

                    public String getFingerprintProtocolPrefix() {
                        InterceptResult invokeV;
                        Interceptable interceptable = $ic;
                        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.fingerprint_protocol_prefix : (String) invokeV.objValue;
                    }

                    public String getFingerprintProtocolUrl() {
                        InterceptResult invokeV;
                        Interceptable interceptable = $ic;
                        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.fingerprint_protocol_url : (String) invokeV.objValue;
                    }
                }

                public Reopen() {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                public FingerprintProtocol getFingerprintProtocol() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.fingerprint_protocol : (FingerprintProtocol) invokeV.objValue;
                }

                public String getSubtitle() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.subtitle : (String) invokeV.objValue;
                }

                public String getTitle() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.title : (String) invokeV.objValue;
                }
            }

            /* loaded from: classes11.dex */
            public static class Update implements NoProguard, Serializable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public String subtitle;
                public String title;

                public Update() {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                public String getSubtitle() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.subtitle : (String) invokeV.objValue;
                }

                public String getTitle() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.title : (String) invokeV.objValue;
                }
            }

            public FingerprintMsg() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public Open getOpen() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.open : (Open) invokeV.objValue;
            }

            public Reopen getReopen() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.reopen : (Reopen) invokeV.objValue;
            }

            public Update getUpdate() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.update : (Update) invokeV.objValue;
            }
        }

        /* loaded from: classes11.dex */
        public static class PassFreeProtocol implements NoProguard, Serializable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String passfree_protocol_msg;
            public String passfree_protocol_prefix;
            public String passfree_protocol_url;

            public PassFreeProtocol() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public String getPassfreeProtocolMsg() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.passfree_protocol_msg : (String) invokeV.objValue;
            }

            public String getPassfreeProtocolPrefix() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.passfree_protocol_prefix : (String) invokeV.objValue;
            }

            public String getPassfreeProtocolUrl() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.passfree_protocol_url : (String) invokeV.objValue;
            }
        }

        /* loaded from: classes11.dex */
        public static class Score implements Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 606605370857740501L;
            public transient /* synthetic */ FieldHolder $fh;
            public String can_cash;
            public String score_num;
            public String score_tip;

            public Score() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
                java.lang.NullPointerException: Cannot read field "wordsInUse" because "set" is null
                	at java.base/java.util.BitSet.or(BitSet.java:943)
                	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:732)
                	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:811)
                	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:88)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:706)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
                	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
                */
            public boolean hasScore() {
                /*
                    r4 = this;
                    com.baidu.titan.sdk.runtime.Interceptable r0 = com.dxmpay.wallet.base.datamodel.UserData.UserModel.Score.$ic
                    if (r0 != 0) goto L27
                L4:
                    java.lang.String r0 = r4.score_num
                    boolean r0 = android.text.TextUtils.isEmpty(r0)
                    r1 = 0
                    if (r0 != 0) goto L26
                    java.lang.String r0 = r4.can_cash
                    boolean r0 = android.text.TextUtils.isEmpty(r0)
                    if (r0 == 0) goto L16
                    goto L26
                L16:
                    java.math.BigDecimal r0 = new java.math.BigDecimal     // Catch: java.lang.Exception -> L26
                    java.lang.String r2 = r4.score_num     // Catch: java.lang.Exception -> L26
                    r0.<init>(r2)     // Catch: java.lang.Exception -> L26
                    java.math.BigDecimal r2 = java.math.BigDecimal.ZERO     // Catch: java.lang.Exception -> L26
                    int r0 = r0.compareTo(r2)     // Catch: java.lang.Exception -> L26
                    if (r0 <= 0) goto L26
                    r1 = 1
                L26:
                    return r1
                L27:
                    r2 = r0
                    r3 = 1048576(0x100000, float:1.469368E-39)
                    com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeV(r3, r4)
                    if (r0 == 0) goto L4
                    boolean r1 = r0.booleanValue
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.wallet.base.datamodel.UserData.UserModel.Score.hasScore():boolean");
            }
        }

        public UserModel() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.has_mobile_password = 0;
            this.balance_support_status = "1";
            this.need_pay_password = "1";
            this.passfree_selected = "1";
        }

        public void decrypt() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (!TextUtils.isEmpty(this.certificate_code_ec)) {
                        this.certificate_code = SecurePay.unicodeDecode(SecurePay.getInstance().localDecryptProxy(this.certificate_code_ec));
                    }
                    if (TextUtils.isEmpty(this.mobile_ec)) {
                        return;
                    }
                    this.mobile_number = SecurePay.unicodeDecode(SecurePay.getInstance().localDecryptProxy(this.mobile_ec));
                } catch (Exception unused) {
                }
            }
        }

        public String getCanAmount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Account account = this.account;
                return account == null ? "0" : account.getCanAmount();
            }
            return (String) invokeV.objValue;
        }

        public FingerprintMsg getFingerprintMsg() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.fingerprint_msg : (FingerprintMsg) invokeV.objValue;
        }

        public String getMoneyUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                Account account = this.account;
                return account != null ? account.return_cash_url : "";
            }
            return (String) invokeV.objValue;
        }

        public String getPassfreeMsg() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.passfree_msg : (String) invokeV.objValue;
        }

        public PassFreeProtocol getPassfreeProtocol() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.passfree_protocol : (PassFreeProtocol) invokeV.objValue;
        }

        public boolean getPassfreeSelected() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "1".equals(this.passfree_selected) : invokeV.booleanValue;
        }

        public String getRecvInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                Account account = this.account;
                return account != null ? account.recv_info : "";
            }
            return (String) invokeV.objValue;
        }

        public String getTotalBackContent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                Account account = this.account;
                return account != null ? account.return_cash_content : "";
            }
            return (String) invokeV.objValue;
        }

        public boolean hasCanAmount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Account account = this.account;
                if (account == null) {
                    return false;
                }
                return account.hasCanAmount();
            }
            return invokeV.booleanValue;
        }

        public boolean hasMobilePwd() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.has_mobile_password == 1 : invokeV.booleanValue;
        }

        public boolean isSupportBalance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? "1".equals(this.balance_support_status) : invokeV.booleanValue;
        }

        public void setHasMobilePwd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                this.has_mobile_password = 1;
            }
        }
    }

    public UserData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
