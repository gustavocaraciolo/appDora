// These constants are injected via webpack environment variables.
// You can add more variables in webpack.common.js or in profile specific webpack.<dev|prod>.js files.
// If you change the values in the webpack config files, you need to re run webpack to update the application

import createNumberMask from 'text-mask-addons/dist/createNumberMask';

export const VERSION = process.env.VERSION;
export const DEBUG_INFO_ENABLED: boolean = !!process.env.DEBUG_INFO_ENABLED;
export const SERVER_API_URL = process.env.SERVER_API_URL;
export const BUILD_TIMESTAMP = process.env.BUILD_TIMESTAMP;
export const MASK_PHONE = [/[1-9]/, /\d/, /\d/, '-', /\d/, /\d/, /\d/, '-', /\d/, /\d/, /\d/];
export const MASK_NUMBER = [/[1-9]/, /\d/, /\d/];
export const MASK_MOEDA_KWANZA = createNumberMask({
    thousandsSeparatorSymbol: '.',
    prefix: '',
    suffix: ',00'
});
