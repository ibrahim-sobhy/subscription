# subscription
Mobile Subscription System


Basket
 List of order items

OrderItem
 category: add service, delete service, new activation, cessation, migration, upgrade, downgrade, device

All items can run in parallel no sequence

IN
=====
add product
    customerId
    product

delete product
    customerId
    product
    expiry date

upgrade
    customerId
    fromProduct
    toProduct
    activation date

downgrade
    customerId
    fromProduct
    toProduct
    activation date
list offers
    customerId

    output: product list


HLR
=====
activation
cessation


Billing
=========
add
    customerId
    product
    amount
remove
    customerId
    product

Service Registry
===========
add
remove

Loyalty
==========
add bonus
add recurring



SMS Gateway
=============
send

Digital apps
==============
notify

Promotion (Discounting system)
================
calculate

Exit Charging
==========
calculate

Payment Gateway
=================
pay -- total amount

Service Dependency
=================
evaluate

Mutual services
==============
evaluate

Eligibility
============
isEligible

Shipment
=========
deliver

