package d.o.a.e.b.l;

import com.baidu.mobads.container.util.SDKLogTypeConstants;
import org.apache.http.HttpStatus;
/* loaded from: classes7.dex */
public class b {
    public static String a(int i2) {
        if (i2 != 449) {
            if (i2 != 451) {
                if (i2 != 600) {
                    if (i2 != 509) {
                        if (i2 != 510) {
                            switch (i2) {
                                case 100:
                                    return "Continue";
                                case 101:
                                    return "Switching Protocols";
                                case 102:
                                    return "Processing";
                                default:
                                    switch (i2) {
                                        case 200:
                                            return "OK";
                                        case 201:
                                            return "Created";
                                        case 202:
                                            return "Accepted";
                                        case 203:
                                            return "Non-Authoritative Information";
                                        case 204:
                                            return "No Content";
                                        case 205:
                                            return "Reset Content";
                                        case 206:
                                            return "Partial Content";
                                        case 207:
                                            return "Multi-Status";
                                        default:
                                            switch (i2) {
                                                case 300:
                                                    return "Multiple Choices";
                                                case 301:
                                                    return "Moved Permanently";
                                                case 302:
                                                    return "Move Temporarily";
                                                case 303:
                                                    return "See Other";
                                                case 304:
                                                    return "Not Modified";
                                                case 305:
                                                    return "Use Proxy";
                                                case 306:
                                                    return "Switch Proxy";
                                                case 307:
                                                    return "Temporary Redirect";
                                                default:
                                                    switch (i2) {
                                                        case 400:
                                                            return "Bad Request";
                                                        case 401:
                                                            return "Unauthorized";
                                                        case 402:
                                                            return "Payment Required";
                                                        case 403:
                                                            return "Forbidden";
                                                        case 404:
                                                            return "Not Found";
                                                        case 405:
                                                            return "Method Not Allowed";
                                                        case 406:
                                                            return "Not Acceptable";
                                                        case 407:
                                                            return "Proxy Authentication Required";
                                                        case 408:
                                                            return "Request Timeout";
                                                        case 409:
                                                            return "Conflict";
                                                        case 410:
                                                            return "Gone";
                                                        case 411:
                                                            return "Length Required";
                                                        case 412:
                                                            return "Precondition Failed";
                                                        case 413:
                                                            return "Request Entity Too Large";
                                                        case 414:
                                                            return "Request-URI Too Long";
                                                        case 415:
                                                            return "Unsupported Media Type";
                                                        case 416:
                                                            return "Requested Range Not Satisfiable";
                                                        case HttpStatus.SC_EXPECTATION_FAILED /* 417 */:
                                                            return "Expectation Failed";
                                                        case SDKLogTypeConstants.TYPE_RSPLASH_HTML_LOG /* 418 */:
                                                            return "I'm a teapot";
                                                        default:
                                                            switch (i2) {
                                                                case 421:
                                                                    return "Too Many Connections";
                                                                case HttpStatus.SC_UNPROCESSABLE_ENTITY /* 422 */:
                                                                    return "Unprocessable Entity";
                                                                case HttpStatus.SC_LOCKED /* 423 */:
                                                                    return "Locked";
                                                                case HttpStatus.SC_FAILED_DEPENDENCY /* 424 */:
                                                                    return "Failed Dependency";
                                                                case SDKLogTypeConstants.TYPE_CRASH_SOURCE /* 425 */:
                                                                    return "Unordered Collection";
                                                                case SDKLogTypeConstants.TYPE_SHOUBAI_APO_INFO /* 426 */:
                                                                    return "Upgrade Required";
                                                                default:
                                                                    switch (i2) {
                                                                        case 500:
                                                                            return "Internal Server Error";
                                                                        case 501:
                                                                            return "Not Implemented";
                                                                        case 502:
                                                                            return "Bad Gateway";
                                                                        case 503:
                                                                            return "Service Unavailable";
                                                                        case 504:
                                                                            return "Gateway Timeout";
                                                                        case 505:
                                                                            return "HTTP Version Not Supported";
                                                                        case 506:
                                                                            return "Variant Also Negotiates";
                                                                        case 507:
                                                                            return "Insufficient Storage";
                                                                        default:
                                                                            return "";
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                            }
                        }
                        return "Not Extended";
                    }
                    return "Bandwidth Limit Exceeded";
                }
                return "Unparseable Response Headers";
            }
            return "Unavailable For Legal Reasons";
        }
        return "Retry With";
    }
}
