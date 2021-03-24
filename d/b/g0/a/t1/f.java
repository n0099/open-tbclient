package d.b.g0.a.t1;

import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public class f {
    public static String a(int i) {
        switch (i) {
            case 2001:
                return AppRuntime.getAppContext().getString(d.b.g0.a.h.aiapps_scheme_err_message_file_not_exist);
            case 2002:
                return AppRuntime.getAppContext().getString(d.b.g0.a.h.aiapps_scheme_err_message_file_too_large);
            case 2003:
                return AppRuntime.getAppContext().getString(d.b.g0.a.h.aiapps_scheme_err_message_file_io_exception);
            case 2004:
                return AppRuntime.getAppContext().getString(d.b.g0.a.h.aiapps_scheme_err_message_files_delete_fail);
            case 2005:
            default:
                return AppRuntime.getAppContext().getString(d.b.g0.a.h.aiapps_scheme_err_message_file_not_exist);
            case 2006:
                return AppRuntime.getAppContext().getString(d.b.g0.a.h.aiapps_scheme_err_message_file_path_invalid);
            case 2007:
                return AppRuntime.getAppContext().getString(d.b.g0.a.h.aiapps_scheme_err_message_ab_switch_off);
        }
    }
}
